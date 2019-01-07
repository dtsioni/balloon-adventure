package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.level.api.Level;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;
import com.tsioni.balloonadventure.screen.api.ScreenFactory;
import com.tsioni.balloonadventure.screen.api.ScreenSetter;

class LevelTheaterScreen implements Screen
{
    private final Level level;
    private final LevelTheater levelTheater;
    private final Batch batch;
    private final ScreenFactory screenFactory;
    private final ScreenSetter screenSetter;
    private final Debug debug;

    private int numberOfMinorGoalsCollected = 0;

    /**
     * TODO: Move this when GUI is needed elsewhere.
     */
    private final Camera guiCamera = new OrthographicCamera();
    {
        guiCamera.combined.setToOrtho2D(
            0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


    @Inject
    public LevelTheaterScreen(
        @Assisted final Level level,
        @Assisted final LevelTheater levelTheater,
        @Assisted final Batch batch,
        final ScreenFactory screenFactory,
        final ScreenSetter screenSetter)
    {
        this.level = level;
        this.levelTheater = levelTheater;
        this.batch = batch;
        this.screenFactory = screenFactory;
        this.screenSetter = screenSetter;
        this.debug = new Debug();
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(final float delta)
    {
        levelTheater.step(delta);

        final LevelGameState levelGameState = levelTheater.getLevelGameState();

        if (numberOfMinorGoalsCollected != levelGameState.numberOfMinorGoalsCollected())
        {
            Debug.out.println("Number of minor goals collected: "
                + levelGameState.numberOfMinorGoalsCollected());

            numberOfMinorGoalsCollected = levelGameState.numberOfMinorGoalsCollected();
        }

        if (levelGameState.playerHasWon() || Gdx.input.isKeyJustPressed(Input.Keys.W))
        {
            Debug.out.println("You win.");

            final Screen screen = screenFactory.createLevelLoadingScreen(
                level.getNextLevel());

            screenSetter.setScreen(screen);
        }
        else if (levelGameState.playerHasLost() || Gdx.input.isKeyJustPressed(Input.Keys.L))
        {
            Debug.out.println("You lose.");
            levelTheater.setLevelState(level.getLevelInitialState());
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /**
         * TODO: If any more of these Begin/Draw/End blocks are needed, use behavior parameterization
         * to avoid the duplicated lines for Batch.begin()/Batch.end().
         */
        batch.begin();
        levelTheater.draw(batch);
        batch.end();

        batch.setProjectionMatrix(guiCamera.combined);

        batch.begin();
        debug.draw(batch);
        batch.end();
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
