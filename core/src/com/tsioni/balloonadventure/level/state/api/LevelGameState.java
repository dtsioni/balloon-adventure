package com.tsioni.balloonadventure.level.state.api;

/**
 * Represents the game state for a single level.
 */
public interface LevelGameState
{
    /**
     * @return whether or not the player has won the level.
     */
    boolean playerHasWon();

    /**
     * @return whether or not the player has lost the level.
     */
    boolean playerHasLost();

    void playerCollectedAGoal();

    void playerDied();

    /**
     * Resets the game state.
     */
    void reset();
}
