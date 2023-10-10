package me.justeli.esqueleto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* Eli @ December 13, 2021 (creation) */
public final class ExecuteUpdate
    extends AbstractStatement
{
    ExecuteUpdate (Esqueleto esqueleto, String statement, Object... replacements)
    {
        super(esqueleto, statement, replacements);
    }

    /**
     * @return The inserted row(s).
     */
    @Override
    ExecutionData execute ()
    {
        try (Connection connection = this.esqueleto.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                 checkForIterable(this.statement, this.replacements),
                 PreparedStatement.RETURN_GENERATED_KEYS
             ))
        {
            parseReplacements(statement, this.replacements);
            int rows = statement.executeUpdate();

            return new ExecutionData(
                statement.getGeneratedKeys(),
                rows
            );
        }
        catch (SQLException exception)
        {
            Esqueleto.printError(exception, this.statement);
            return new ExecutionData(null, 0);
        }
    }

    /**
     * @return The total amount of successfully updated or inserted row(s).
     */
    public int complete ()
    {
        return execute().rows();
    }

    /**
     * Queue onto a queued thread.
     */
    public void queue ()
    {
        this.esqueleto.getConfig().getQueueService().submit(() -> complete(results -> {}));
    }

    /**
     * Push onto an async thread.
     */
    public void push ()
    {
        this.esqueleto.getConfig().getAsyncService().submit(() -> complete(results -> {}));
    }
}
