package com.tsioni.balloonadventure.gui.impl;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.gui.api.Gui;
import com.tsioni.balloonadventure.gui.api.LevelTheaterGuiFactory;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

class LevelTheaterGuiFactoryImpl implements LevelTheaterGuiFactory
{
    private final GuiStageFactory guiStageFactory;

    @Inject
    LevelTheaterGuiFactoryImpl(
        final GuiStageFactory guiStageFactory)
    {
        this.guiStageFactory = guiStageFactory;
    }

    @Override
    public Gui createLevelTheaterGui(
        final Batch batch,
        final LevelGameState levelGameState)
    {
        return new LevelTheaterGuiImpl(guiStageFactory.createGuiStage(batch), levelGameState);
    }
}
