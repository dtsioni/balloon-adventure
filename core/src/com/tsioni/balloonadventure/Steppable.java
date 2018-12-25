package com.tsioni.balloonadventure;

/**
 * Something that can be stepped.
 */
public interface Steppable
{
    /**
     * The change in time in milliseconds since the last step was called.
     */
    void step(float delta);
}
