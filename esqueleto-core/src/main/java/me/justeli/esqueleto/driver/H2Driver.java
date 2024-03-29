package me.justeli.esqueleto.driver;

/* Eli @ January 02, 2023 (creation) */
public final class H2Driver
    implements SqlDriver
{
    @Override
    public String className ()
    {
        return "org.h2.jdbcx.JdbcDataSource";
    }

    @Override
    public String dependency ()
    {
        return """
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.2.224</version>""";
    }

    @Override
    public boolean supportsProperties ()
    {
        return false;
    }
}
