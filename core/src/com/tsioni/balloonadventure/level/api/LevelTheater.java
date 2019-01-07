package com.tsioni.balloonadventure.level.api;

import com.tsioni.balloonadventure.Drawable;
import com.tsioni.balloonadventure.Steppable;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

/**
 * A playable level. This theater is Drawable and Steppable, which is the primary way it will be
 * advanced through time and viewed.
 */
public interface LevelTheater extends Drawable, Steppable
{
    /**
     * @return Get the current game state for the level.
     */
    LevelGameState getLevelGameState();

    /**
     * Set the level to an initial state.
     */
    void setLevelState(LevelInitialState levelState);
}
