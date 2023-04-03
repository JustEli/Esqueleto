package me.justeli.esqueleto.driver;

/* Eli @ January 02, 2023 (creation) */
public final class MySQLDriver
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
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.31</version>""";
    }

    @Override
    public boolean supportsProperties ()
    {
        return false;
    }
}
