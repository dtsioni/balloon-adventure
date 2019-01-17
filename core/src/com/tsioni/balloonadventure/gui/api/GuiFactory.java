package com.tsioni.balloonadventure.gui.api;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.tsioni.balloonadventure.level.api.Level;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

public interface GuiFactory
{
    /**
     * Create a level theater gui.
     *
     * @param batch The batch to use when drawing.
     * @param level The level being played.
     * @param levelGameState The game state to use initially.
     */
    Gui createLevelTheaterGui(
        Batch batch,
        Level level,
        LevelGameState levelGameState);

    LevelSelectGui createLevelSelectGui(
        Batch batch);
}
