package com.tsioni.balloonadventure.gui.api;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

public interface LevelTheaterGuiFactory
{
    /**
     * Create a level theater gui.
     *
     * @param batch The batch to use when drawing.
     * @param levelGameState The game state to use initially.
     */
    Gui createLevelTheaterGui(
        Batch batch,
        LevelGameState levelGameState);
}
