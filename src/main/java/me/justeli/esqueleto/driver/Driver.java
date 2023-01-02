package me.justeli.esqueleto.driver;

/* Eli @ December 29, 2022 (creation) */
public interface Driver
{
    String className();

    String dependency();

    boolean supportsProperties ();
}
