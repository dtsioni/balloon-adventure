package com.tsioni.balloonadventure.model.api;

public abstract class AbstractId
{
    private final String id;

    public AbstractId(
        final String id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(
        final Object id)
    {
        return id instanceof AbstractId && this.id.equals(((AbstractId) id).id);
    }

    @Override
    public String toString()
    {
        return id;
    }
}
