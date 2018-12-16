package com.tsioni.balloonadventure;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tsioni.balloonadventure.screen.LevelTheaterScreen;

import javax.inject.Inject;

public class BalloonAdventure extends Game
{
    private SpriteBatch batch;
    private Texture img;

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

    @Inject
    private LevelTheaterScreen levelTheaterScreen;
}
