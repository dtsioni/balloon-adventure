package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Screen;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.level.api.*;
import com.tsioni.balloonadventure.screen.api.ScreenFactory;
import com.tsioni.balloonadventure.screen.api.ScreenSetter;

class LevelLoadingScreen implements Screen
{
    private final LevelId levelId;
    private final LevelInitialStateFetcher levelInitialStateFetcher;
    private final LevelTheaterGenerator levelTheaterGenerator;
    private final ScreenFactory screenFactory;
    private final ScreenSetter screenSetter;

    private Screen loadedLevelTheaterScreen;

    @Inject
    LevelLoadingScreen(
        @Assisted final LevelId levelId,
        final LevelInitialStateFetcher levelInitialStateFetcher,
        final LevelTheaterGenerator levelTheaterGenerator,
        final ScreenFactory screenFactory,
        final ScreenSetter screenSetter)
    {
        this.levelId = levelId;
        this.levelInitialStateFetcher = levelInitialStateFetcher;
        this.levelTheaterGenerator = levelTheaterGenerator;
        this.screenFactory = screenFactory;
        this.screenSetter = screenSetter;

        loadedLevelTheaterScreen = null;
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(final float delta)
    {
        final LevelInitialState levelInitialState = levelInitialStateFetcher.fetchLevelInitialState(levelId);

        final LevelTheater levelTheater = levelTheaterGenerator.generateLevelTheater(levelInitialState);

        loadedLevelTheaterScreen = screenFactory.createLevelTheaterScreen(levelTheater);
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
        /**
         * TODO: Handle the case when dispose is called before the level is loaded.
         */
        screenSetter.setScreen(loadedLevelTheaterScreen);
    }
}
