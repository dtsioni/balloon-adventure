package com.tsioni.balloonadventure.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.level.api.LevelInitialStateFetcher;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.api.LevelTheaterGenerator;
import com.tsioni.balloonadventure.level.api.LevelInitialState;

public class LevelLoadingScreen implements Screen
{
    private final Game game;
    private final LevelId levelId;
    private final LevelInitialStateFetcher levelInitialStateFetcher;
    private final LevelTheaterGenerator levelTheaterGenerator;
    private final LevelTheaterScreenFactory levelTheaterScreenFactory;

    private LevelTheaterScreen loadedLevelTheaterScreen;

    LevelLoadingScreen(
        final Game game,
        final LevelId levelId,
        final LevelInitialStateFetcher levelInitialStateFetcher,
        final LevelTheaterGenerator levelTheaterGenerator,
        final LevelTheaterScreenFactory levelTheaterScreenFactory)
    {
        this.game = game;
        this.levelId = levelId;
        this.levelInitialStateFetcher = levelInitialStateFetcher;
        this.levelTheaterGenerator = levelTheaterGenerator;
        this.levelTheaterScreenFactory = levelTheaterScreenFactory;

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

        loadedLevelTheaterScreen = levelTheaterScreenFactory.createLevelTheaterScreen(levelTheater);
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
        game.setScreen(loadedLevelTheaterScreen);
    }
}
