package com.tsioni.balloonadventure.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.screen.impl.LevelTheaterScreen;

class BalloonAdventure extends Game
{
    private SpriteBatch batch;
    private Texture img;
    private final LevelTheaterScreen levelTheaterScreen;

    @Inject
    public BalloonAdventure(
        final LevelTheaterScreen levelTheaterScreen)
    {
        this.levelTheaterScreen = levelTheaterScreen;
    }

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void resize(final int width, final int height)
    {

    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
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
    public void dispose()
    {
        batch.dispose();
        img.dispose();
    }
}
