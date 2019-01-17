package com.tsioni.balloonadventure.gui.api;

import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.util.api.Optional;

public interface LevelSelectGui extends Gui
{
    Optional<LevelId> getSelectedLevelId();
}
