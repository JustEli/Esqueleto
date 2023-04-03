package me.justeli.esqueleto.driver;

/* Eli @ January 02, 2023 (creation) */

/**
 * <pre>
 * CREATE DATABASE esqueleto_test;
 * USE esqueleto_test;
 * CREATE LOGIN esqueleto WITH PASSWORD = 'dAQ5g61NT';
 * CREATE USER esqueleto FOR LOGIN esqueleto;
 * EXEC sp_addrolemember 'db_owner', 'esqueleto';
 * </pre>
 */
public final class MSSQLDriver
    implements SqlDriver
{
    @Override
    public String className ()
    {
        return null;
    }

    @Override
    public String dependency ()
    {
        return """
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>11.2.2.jre11</version>""";
    }

    @Override
    public boolean supportsProperties ()
    {
        return false;
    }

    @Override
    public String portKey ()
    {
        return "portNumber";
    }
}
