package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.level.api.*;
import com.tsioni.balloonadventure.screen.api.ScreenFactory;
import com.tsioni.balloonadventure.screen.api.ScreenSetter;

class LevelLoadingScreen implements Screen
{
    private final Batch batch;
    private final LevelId levelId;
    private final LevelFetcher levelFetcher;
    private final LevelTheaterGenerator levelTheaterGenerator;
    private final ScreenFactory screenFactory;
    private final ScreenSetter screenSetter;

    @Inject
    LevelLoadingScreen(
        @Assisted final Batch batch,
        @Assisted final LevelId levelId,
        final LevelFetcher levelFetcher,
        final LevelTheaterGenerator levelTheaterGenerator,
        final ScreenFactory screenFactory,
        final ScreenSetter screenSetter)
    {
        this.batch = batch;
        this.levelId = levelId;
        this.levelFetcher = levelFetcher;
        this.levelTheaterGenerator = levelTheaterGenerator;
        this.screenFactory = screenFactory;
        this.screenSetter = screenSetter;
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(final float delta)
    {
        Debug.out.println("Loading level " + levelId);

        final Level level = levelFetcher.fetchLevel(levelId);

        final LevelTheater levelTheater = levelTheaterGenerator.generateLevelTheater(
            level.getLevelInitialState(), batch);

        final Screen loadedLevelTheaterScreen = screenFactory.createLevelTheaterScreen(
            batch, level, levelTheater);

        screenSetter.setScreen(loadedLevelTheaterScreen);
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
