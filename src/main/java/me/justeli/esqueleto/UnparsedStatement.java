package me.justeli.esqueleto;

import javax.annotation.CheckReturnValue;

/* Eli @ April 13, 2021 (creation) */
@CheckReturnValue
public final class UnparsedStatement
{
    private final Esqueleto esqueleto;
    private final String statement;
    private final Object[] replacements;

    UnparsedStatement (Esqueleto esqueleto, String statement, Object... replacements)
    {
        this.esqueleto = esqueleto;
        this.statement = statement;
        this.replacements = replacements;
    }

    public ExecuteUpdate update ()
    {
        return new ExecuteUpdate(this.esqueleto, this.statement, this.replacements);
    }

    public ExecuteQuery query ()
    {
        return new ExecuteQuery(this.esqueleto, this.statement, this.replacements);
    }
}
