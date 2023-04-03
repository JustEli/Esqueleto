package me.justeli.esqueleto.driver;

/* Eli @ January 02, 2023 (creation) */
public final class PostgreSQLDriver
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
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.5.1</version>""";
    }

    @Override
    public boolean supportsProperties ()
    {
        return false;
    }
}
