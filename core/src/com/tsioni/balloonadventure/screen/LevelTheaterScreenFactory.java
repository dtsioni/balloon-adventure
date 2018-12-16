package com.tsioni.balloonadventure.screen;

import com.tsioni.balloonadventure.level.api.LevelTheater;

public interface LevelTheaterScreenFactory
{
    /**
     * Create a new level theater screen.
     */
    LevelTheaterScreen createLevelTheaterScreen(LevelTheater levelTheater);
}
