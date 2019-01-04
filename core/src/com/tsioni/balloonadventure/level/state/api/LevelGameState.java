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

    /**
     * Set whether or not the player has won.
     */
    void setPlayerHasWon(boolean playerHasWon);
}
