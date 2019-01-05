package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

class LevelTheaterScreen implements Screen
{
    private final LevelTheater levelTheater;
    private final Debug debug;

    @Inject
    public LevelTheaterScreen(
        @Assisted final LevelTheater levelTheater)
    {
        this.levelTheater = levelTheater;
        this.debug = new Debug();
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

        final LevelGameState levelGameState = levelTheater.getLevelGameState();

        if (levelGameState.playerHasWon() || Gdx.input.isKeyPressed(Input.Keys.W))
        {
            Debug.out.println("You win.");
            levelTheater.restartLevel();
        }

        debug.draw();
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
