package me.justeli.esqueleto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* Eli @ April 13, 2021 (creation) */
public final class ExecuteQuery
    extends AbstractStatement
{
    ExecuteQuery (Esqueleto esqueleto, String statement, Object... replacements)
    {
        super(esqueleto, statement, replacements);
    }

    /**
     * @return The row(s) requested in the query.
     */
    @Override
    ExecutionData execute ()
    {
        try (Connection connection = this.esqueleto.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                 checkForIterable(this.statement, this.replacements)
             ))
        {
            parseReplacements(statement, this.replacements);
            return new ExecutionData(statement.executeQuery(), 0);
        }
        catch (SQLException exception)
        {
            Esqueleto.printError(exception, this.statement);
            return new ExecutionData(null, 0);
        }
    }
}
