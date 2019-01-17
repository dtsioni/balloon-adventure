package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.gui.api.Gui;
import com.tsioni.balloonadventure.gui.api.GuiFactory;
import com.tsioni.balloonadventure.level.api.Level;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;
import com.tsioni.balloonadventure.screen.api.ScreenFactory;
import com.tsioni.balloonadventure.screen.api.ScreenSetter;

class LevelTheaterScreen implements Screen
{
    private final Batch batch;
    private final Level level;
    private final LevelTheater levelTheater;
    private final Gui levelTheaterGui;
    private final ScreenFactory screenFactory;
    private final ScreenSetter screenSetter;

    private final Debug debug;

    private int numberOfMinorGoalsCollected = 0;

    @Inject
    public LevelTheaterScreen(
        @Assisted final Batch batch,
        @Assisted final Level level,
        @Assisted final LevelTheater levelTheater,
        final GuiFactory guiFactory,
        final ScreenFactory screenFactory,
        final ScreenSetter screenSetter)
    {
        this.batch = batch;
        this.level = level;
        this.levelTheater = levelTheater;
        this.screenFactory = screenFactory;
        this.screenSetter = screenSetter;
        this.debug = new Debug(batch);
        this.levelTheaterGui = guiFactory.createLevelTheaterGui(
            batch, level, levelTheater.getLevelGameState());
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(final float delta)
    {
        levelTheater.step(delta);
        levelTheaterGui.step(delta);

        final LevelGameState levelGameState = levelTheater.getLevelGameState();

        if (levelGameState.playerHasWon() || Gdx.input.isKeyJustPressed(Input.Keys.W))
        {
            Debug.out.println("You win.");

            final Screen screen = screenFactory.createLevelLoadingScreen(
                batch,
                level.getNextLevel());

            screenSetter.setScreen(screen);
        }
        else if (levelGameState.playerHasLost() || Gdx.input.isKeyJustPressed(Input.Keys.L))
        {
            Debug.out.println("You lose.");
            levelTheater.setLevelState(level.getLevelInitialState());
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        levelTheater.draw();
        levelTheaterGui.draw();
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
