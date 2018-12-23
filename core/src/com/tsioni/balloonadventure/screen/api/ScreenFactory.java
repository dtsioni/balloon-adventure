package com.tsioni.balloonadventure.screen.api;

import com.badlogic.gdx.Screen;
import com.google.inject.name.Named;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.level.api.LevelTheater;

public interface ScreenFactory
{
    /**
     * Create a new level theater screen.
     */
    @Named(Screens.LEVEL_THEATER_SCREEN) Screen createLevelTheaterScreen(LevelTheater levelTheater);

    /**
     * Create a new level loading screen which will load the given level, then set the screen to the corresponding
     * level theater screen.
     */
    @Named(Screens.LEVEL_LOADING_SCREEN) Screen createLevelLoadingScreen(LevelId levelId);
}
