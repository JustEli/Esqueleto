package me.justeli.esqueleto.driver;

/* Eli @ January 02, 2023 (creation) */
public final class PostgreSQLDriver
    implements SqlDriver
{
    @Override
    public String className ()
    {
        return "org.postgresql.ds.PGSimpleDataSource";
    }

    @Override
    public String dependency ()
    {
        return """
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.6.0</version>""";
    }

    @Override
    public boolean supportsProperties ()
    {
        return false;
    }
}
