package com.tsioni.balloonadventure.level.api;

import com.badlogic.gdx.utils.viewport.Viewport;

public interface LevelTheaterGenerator
{
    /**
     * @param levelInitialState The initial state to start the level theater at.
     * @param viewport The viewport to use when viewing the level theater.
     */
    LevelTheater generateLevelTheater(LevelInitialState levelInitialState, Viewport viewport);
}
