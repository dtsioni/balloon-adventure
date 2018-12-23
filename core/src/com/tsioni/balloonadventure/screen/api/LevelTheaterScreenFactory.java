package com.tsioni.balloonadventure.screen.api;

import com.badlogic.gdx.Screen;
import com.tsioni.balloonadventure.level.api.LevelTheater;

public interface LevelTheaterScreenFactory
{
    /**
     * Create a new level theater screen.
     */
    Screen createLevelTheaterScreen(LevelTheater levelTheater);
}
