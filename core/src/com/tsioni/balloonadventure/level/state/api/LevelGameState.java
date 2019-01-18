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

    /**
     * @return the number of minor goals collected by the player.
     */
    int numberOfMinorGoalsCollected();

    /**
     * @return whether or not the game is paused.
     */
    boolean gameIsPaused();

    /**
     * The state should reflect that the player collected a Goal.
     */
    void playerCollectedAGoal();

    /**
     * The state should reflect that the player collected a Minor Goal.
     */
    void playerCollectedAMinorGoal();

    /**
     * The state should reflect that the player has died.
     */
    void playerDied();

    /**
     * The state should reflect that the game has paused.
     */
    void pauseGame();

    /**
     * The state should reflect that the game has played.
     */
    void playGame();

    /**
     * Resets the game state.
     */
    void reset();
}
