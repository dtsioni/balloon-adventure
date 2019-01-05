package com.tsioni.balloonadventure.level.api;

import com.tsioni.balloonadventure.Drawable;
import com.tsioni.balloonadventure.Steppable;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

/**
 * A playable level. A theater can be stepped through time and drawn.
 */
public interface LevelTheater
{
    /**
     * @return The drawable for the theater. This will draw the theater.
     */
    Drawable getDrawable();

    /**
     * @return The steppable for the theater. This will step the theater.
     */
    Steppable getSteppable();

    /**
     * @return Get the current game state for the level.
     */
    LevelGameState getLevelGameState();

    /**
     * Set the level back to it's initial state.
     */
    void restartLevel();
}
