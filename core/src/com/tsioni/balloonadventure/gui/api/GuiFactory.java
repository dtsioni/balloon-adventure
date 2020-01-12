package com.tsioni.balloonadventure.gui.api;

import com.tsioni.balloonadventure.level.api.Level;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

public interface GuiFactory
{
    /**
     * Create a level theater gui.
     *
     * @param level The level being played.
     * @param levelGameState The game state to use initially.
     */
    LevelTheaterGui createLevelTheaterGui(
        Level level,
        LevelGameState levelGameState);

    LevelSelectGui createLevelSelectGui();
}
