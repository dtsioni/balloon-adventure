package com.tsioni.balloonadventure.level.api;

/**
 * The information which represents a level in the game.
 */
public interface Level
{
    /**
     * @return the LevelId of this level.
     */
    LevelId getLevelId();

    /**
     * @return the LevelId of the level to play after this one.
     */
    LevelId getNextLevel();

    /**
     * @return this level's initial state.
     */
    LevelInitialState getLevelInitialState();
}
