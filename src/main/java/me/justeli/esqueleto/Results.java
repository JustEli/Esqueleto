package me.justeli.esqueleto;

import me.justeli.esqueleto.binary.Binary;
import org.jetbrains.annotations.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/* Eli @ December 28, 2022 (creation) */
public final class Results
{
    private final ResultSet resultSet;
    private final Esqueleto sql;

    Results (@Nullable ResultSet resultSet, Esqueleto sql)
    {
        this.resultSet = resultSet;
        this.sql = sql;
    }

    public boolean next ()
    throws SQLException
    {
        return this.resultSet != null && this.resultSet.next();
    }

    @Nullable
    public <T> T get (String column)
    throws SQLException
    {
        if (this.resultSet == null)
            return null;

        if (this.resultSet.isBeforeFirst())
            next();

        T type = (T) this.resultSet.getObject(column);
        return this.resultSet.wasNull()? null : type;
    }

    @Nullable
    public <T> T get (String column, Class<T> type)
    throws SQLException
    {
        if (this.resultSet == null)
            return null;

        if (this.resultSet.isBeforeFirst())
            next();

        Binary<?> binary = this.sql.getConfig().getBinaryTransformer(type);
        if (binary != null)
        {
            return (T) binary.to(this.resultSet.getBytes(column));
        }
        return get(column);
    }
}
