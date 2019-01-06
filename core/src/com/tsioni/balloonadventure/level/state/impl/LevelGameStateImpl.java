package com.tsioni.balloonadventure.level.state.impl;

import com.tsioni.balloonadventure.level.state.api.LevelGameState;

class LevelGameStateImpl implements LevelGameState
{
    private boolean playerHasWon = false;
    private boolean playerHasLost = false;
    private int numberOfMinorGoalsCollected = 0;

    @Override
    public boolean playerHasWon()
    {
        return playerHasWon;
    }

    @Override
    public boolean playerHasLost()
    {
        return playerHasLost;
    }

    @Override
    public int numberOfMinorGoalsCollected()
    {
        return numberOfMinorGoalsCollected;
    }

    @Override
    public void playerCollectedAGoal()
    {
        playerHasWon = true;
    }

    @Override
    public void playerCollectedAMinorGoal()
    {
        numberOfMinorGoalsCollected++;
    }

    @Override
    public void playerDied()
    {
        playerHasLost = true;
    }

    @Override
    public void reset()
    {
        playerHasWon = false;
        playerHasLost = false;
        numberOfMinorGoalsCollected = 0;
    }
}
