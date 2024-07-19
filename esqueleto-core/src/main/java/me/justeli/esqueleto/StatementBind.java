package me.justeli.esqueleto;

import me.justeli.esqueleto.annotation.CheckReturnValue;

/* Eli @ July 19, 2024 (creation) */
public final class StatementBind
{
    private final Esqueleto esqueleto;
    private final String statement;
    private final Object[] replacements;

    StatementBind (Esqueleto esqueleto, String statement, Object... replacements)
    {
        this.esqueleto = esqueleto;
        this.statement = statement;
        this.replacements = replacements;
    }

    @CheckReturnValue
    public ExecuteUpdate update ()
    {
        return new ExecuteUpdate(this.esqueleto, this.statement, this.replacements);
    }

    @CheckReturnValue
    public ExecuteQuery query ()
    {
        return new ExecuteQuery(this.esqueleto, this.statement, this.replacements);
    }
}
