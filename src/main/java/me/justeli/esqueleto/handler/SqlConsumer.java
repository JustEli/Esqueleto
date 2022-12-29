package me.justeli.esqueleto.handler;

import java.sql.SQLException;

/* Eli @ April 13, 2021 (creation) */
@FunctionalInterface
public interface SqlConsumer<T>
{
    void accept (T t)
    throws SQLException;
}
