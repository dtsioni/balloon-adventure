package com.tsioni.balloonadventure.input.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.tsioni.balloonadventure.input.api.DelegatingInputProcessor;
import com.tsioni.balloonadventure.input.api.InputProcessorRegistry;

class LibgdxInputProcessorRegistry implements InputProcessorRegistry
{
    @Override
    public void registerInputProcessor(
        final InputProcessor inputProcessor)
    {
        if (Gdx.input.getInputProcessor() == null)
        {
            Gdx.input.setInputProcessor(new DelegatingInputProcessor(
                inputProcessor));
        }
        else
        {
            Gdx.input.setInputProcessor(new DelegatingInputProcessor(
                Gdx.input.getInputProcessor(),
                inputProcessor));
        }
    }
}
