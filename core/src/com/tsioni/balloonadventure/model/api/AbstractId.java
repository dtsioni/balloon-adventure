package com.tsioni.balloonadventure.model.api;

public abstract class AbstractId
{
    private final String id;

    public AbstractId(
        final String id)
    {
        this.id = id;
    }

    private String getId()
    {
        return id;
    }

    @Override
    public boolean equals(
        final Object id)
    {
        return id instanceof AbstractId && this.getId().equals(((AbstractId) id).getId());
    }

    @Override
    public String toString()
    {
        return getId();
    }
}
