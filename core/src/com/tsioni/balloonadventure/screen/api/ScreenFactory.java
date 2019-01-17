package com.tsioni.balloonadventure.screen.api;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.google.inject.name.Named;
import com.tsioni.balloonadventure.level.api.Level;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.level.api.LevelTheater;

public interface ScreenFactory
{
    /**
     * Create a new level theater screen.
     *
     * @param batch The batch to use for drawing.
     * @param level The level that this screen is playing.
     * @param levelTheater The level theater which is playing the level.
     * @return
     */
    @Named(Screens.LEVEL_THEATER_SCREEN) Screen createLevelTheaterScreen(
        Batch batch,
        Level level,
        LevelTheater levelTheater);

    /**
     * Create a new level loading screen which will load the given level, then set the screen to the corresponding
     * level theater screen.
     */
    @Named(Screens.LEVEL_LOADING_SCREEN) Screen createLevelLoadingScreen(
        Batch batch,
        LevelId levelId);

    /**
     * Create a new level select screen which will allow the user to select a level, and then set the
     * screen to a new loading screen for that level.
     */
    @Named(Screens.LEVEL_SELECT_SCREEN) Screen createLevelSelectScreen(
        Batch batch);
}
