package com.tsioni.balloonadventure.level.api;

public interface LevelInitialStateFetcher
{
    /**
     * @return The initial state of the given level.
     */
    LevelInitialState fetchLevelInitialState(LevelId levelId);
}
