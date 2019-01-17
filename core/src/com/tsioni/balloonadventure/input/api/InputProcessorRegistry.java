package com.tsioni.balloonadventure.input.api;

import com.badlogic.gdx.InputProcessor;

/**
 * Represents the registry of input processors which handle input.
 */
public interface InputProcessorRegistry
{
    /**
     * Register a new input processor which will handle input.
     */
    void registerInputProcessor(InputProcessor inputProcessor);
}
