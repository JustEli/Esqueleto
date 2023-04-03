package me.justeli.esqueleto;

import com.zaxxer.hikari.HikariConfig;
import me.justeli.esqueleto.binary.IP4Binary;
import me.justeli.esqueleto.binary.Binary;
import me.justeli.esqueleto.binary.UuidBinary;
import me.justeli.esqueleto.driver.SqlDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/* Eli @ April 13, 2021 (creation) */
/* Eli @ December 26, 2022 (rewrite) */
public final class SqlConfig
    extends HikariConfig
{
    private ExecutorService queueService = Executors.newSingleThreadExecutor();
    private ExecutorService asyncService = ForkJoinPool.commonPool();

    private SqlDriver driver;

    SqlConfig ()
    {
//        super.addDataSourceProperty("properties", "useUnicode=true;characterEncoding=utf8;useSSL=false;socketTimeout=30000");

        super.setMaximumPoolSize(10);
        super.setMinimumIdle(10);
        super.setMaxLifetime(1800000);
        super.setKeepaliveTime(0);
        super.setConnectionTimeout(5000);
        super.setInitializationFailTimeout(-1);

        registerBinaryTransformer(new IP4Binary());
        registerBinaryTransformer(new UuidBinary());
    }

    public void setQueueService (ExecutorService queueService)
    {
        this.queueService.shutdown();
        this.queueService = queueService;
    }

    public ExecutorService getQueueService ()
    {
        return queueService;
    }

    public void setAsyncService (ExecutorService asyncService)
    {
        this.asyncService.shutdown();
        this.asyncService = asyncService;
    }

    public ExecutorService getAsyncService ()
    {
        return asyncService;
    }

    public void setHost (String host)
    {
        super.addDataSourceProperty("serverName", host);
    }

    public void setPort (int port)
    {
        super.addDataSourceProperty("port", String.valueOf(port));
    }

    public void setDatabase (String database)
    {
        super.addDataSourceProperty("databaseName", database);
    }

    @Deprecated
    public void setAdapter (String adapter)
    {
        super.setDataSourceClassName(adapter);
    }

    public void setDriver (SqlDriver driver)
    {
        this.driver = driver;
        super.setDataSourceClassName(driver.className());
    }

    public <T extends SqlDriver> void setDriver (Class<T> clazz)
    {
        try
        {
            setDriver(clazz.getConstructor().newInstance());
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException exception)
        {
            throw new RuntimeException(exception);
        }
    }

    private final Map<Class<?>, Binary<?>> transformers = new HashMap<>();

    public <T> void registerBinaryTransformer (Binary<T> binary)
    {
        this.transformers.put(binary.type(), binary);
    }

    public <T> Binary<T> getBinaryTransformer (Class<T> type)
    {
        return (Binary<T>) this.transformers.get(type);
    }

    private boolean debug;

    public void setDebug (boolean debug)
    {
        this.debug = debug;
    }

    public boolean isDebug ()
    {
        return debug;
    }
}
