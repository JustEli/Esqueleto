package me.justeli.esqueleto.driver;

/* Eli @ December 29, 2022 (creation) */
public interface SqlDriver
{
    String className();

    String dependency();

    boolean supportsProperties ();

    default String portKey ()
    {
        return "port";
    }
}
