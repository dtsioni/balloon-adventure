package com.tsioni.balloonadventure.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.tsioni.balloonadventure.level.api.LevelTheater;

public class LevelTheaterScreen implements Screen
{
    private final LevelTheater levelTheater;

    public LevelTheaterScreen(final LevelTheater levelTheater)
    {
        this.levelTheater = levelTheater;
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(levelTheater.getInputProcessor());
    }

    @Override
    public void render(final float delta)
    {
        levelTheater.stepTheater(delta);
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
