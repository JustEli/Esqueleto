package me.justeli.esqueleto.examples.data;

import java.io.Serializable;

/* Eli @ December 28, 2022 (creation) */
public record Example(int number, String message)
    implements Serializable
{}
