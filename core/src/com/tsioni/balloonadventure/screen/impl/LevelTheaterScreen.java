package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.level.api.LevelTheater;

class LevelTheaterScreen implements Screen
{
    private final LevelTheater levelTheater;

    @Inject
    public LevelTheaterScreen(
        @Assisted final LevelTheater levelTheater)
    {
        this.levelTheater = levelTheater;
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(final float delta)
    {
        levelTheater.getSteppable().step(delta);
        levelTheater.getDrawable().draw();
    }

    @Override
    public void resize(final int width, final int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
