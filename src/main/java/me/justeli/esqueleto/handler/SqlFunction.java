package me.justeli.esqueleto.handler;

import java.sql.SQLException;

/* Eli @ April 13, 2021 (creation) */
@FunctionalInterface
public interface SqlFunction<T, R>
{
    R apply (T t)
    throws SQLException;
}
