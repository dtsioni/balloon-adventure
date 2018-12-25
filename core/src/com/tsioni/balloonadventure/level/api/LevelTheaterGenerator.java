package com.tsioni.balloonadventure.level.api;

public interface LevelTheaterGenerator
{
    /**
     * @return A LevelTheater set to the LevelInitialState.
     */
    LevelTheater generateLevelTheater(LevelInitialState levelInitialState);
}
