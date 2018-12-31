package com.tsioni.balloonadventure.util.api;

public class Optional<T>
{
    private final T t;

    Optional()
    {
        this.t = null;
    }

    Optional(final T t)
    {
        this.t = t;
    }

    public T get()
    {
        return t;
    }

    public boolean isPresent()
    {
        return t != null;
    }

    public static <T> Optional<T> of(T val)
    {
        return new Optional<T>(val);
    }

    public static <T> Optional<T> empty()
    {
        return new Optional<T>(null);
    }
}
