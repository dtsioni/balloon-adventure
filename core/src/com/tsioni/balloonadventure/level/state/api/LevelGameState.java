package com.tsioni.balloonadventure.level.state.api;

/**
 * Represents the game state for a single level.
 */
public interface LevelGameState
{
    /**
     * @return Whether or not the player has won the level.
     */
    boolean playerHasWon();

    void playerCollectedAGoal();

    /**
     * Resets the game state. This should only be used for debug purposes.
     */
    void reset();
}
