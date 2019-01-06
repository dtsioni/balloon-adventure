package com.tsioni.balloonadventure.level.api;

/**
 * Fetches levels.
 */
public interface LevelFetcher
{
    /**
     * @return the level corresponding to the given Id.
     */
    Level fetchLevel(LevelId levelId);
}
