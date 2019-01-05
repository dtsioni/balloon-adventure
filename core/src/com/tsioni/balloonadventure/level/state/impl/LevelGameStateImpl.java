package com.tsioni.balloonadventure.level.state.impl;

import com.tsioni.balloonadventure.level.state.api.LevelGameState;

class LevelGameStateImpl implements LevelGameState
{
    private boolean playerHasWon = false;

    @Override
    public boolean playerHasWon()
    {
        return playerHasWon;
    }

    @Override
    public void playerCollectedAGoal()
    {
        playerHasWon = true;
    }

    @Override
    public void reset()
    {
        playerHasWon = false;
    }
}
