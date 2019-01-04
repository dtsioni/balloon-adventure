package com.tsioni.balloonadventure.level.state.api;

public interface LevelGameStateFactory
{
    /**
     * @return A new level game state in it's initial state.
     */
    LevelGameState createLevelGameState();
}
