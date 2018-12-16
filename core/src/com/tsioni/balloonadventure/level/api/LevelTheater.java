package com.tsioni.balloonadventure.level.api;

import com.badlogic.gdx.InputProcessor;
import com.tsioni.balloonadventure.Drawable;

/**
 * The interactive level.
 */
public interface LevelTheater
{
    /**
     * The input processor for the theater.
     */
    InputProcessor getInputProcessor();

    /**
     * The drawable for the theater.
     */
    Drawable getDrawable();

    /**
     * Advances the theater in response to the current processed input.
     *
     * @param deltaTime The number of milliseconds since stepTheater was last called.
     */
    void stepTheater(float deltaTime);
}
