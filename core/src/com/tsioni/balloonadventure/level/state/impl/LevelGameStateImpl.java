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
    public void setPlayerHasWon(final boolean playerHasWon)
    {
        this.playerHasWon = playerHasWon;
    }
}
