package me.justeli.esqueleto.driver;

/* Eli @ January 02, 2023 (creation) */
public final class SQLiteDriver
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
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <version>3.43.0.0</version>""";
    }

    @Override
    public boolean supportsProperties ()
    {
        return false;
    }
}
