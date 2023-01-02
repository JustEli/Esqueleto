package me.justeli.esqueleto.driver;

/* Eli @ December 29, 2022 (creation) */
public class MariaDB
    implements Driver
{
    @Override
    public String className ()
    {
        return "org.mariadb.jdbc.MariaDbDataSource";
    }

    @Override
    public String dependency ()
    {
        return """
            <groupId>org.mariadb.jdbc</groupId>
            <artifactId>mariadb-java-client</artifactId>
            <version>2.7.7</version>
            """;
    }

    @Override
    public boolean supportsProperties ()
    {
        return true;
    }
}
