package com.tsioni.balloonadventure.gui.impl;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.tsioni.balloonadventure.gui.api.Gui;
import com.tsioni.balloonadventure.gui.api.GuiFactory;
import com.tsioni.balloonadventure.gui.api.LevelSelectGui;

public class GuiInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new FactoryModuleBuilder()
            .implement(Gui.class, LevelTheaterGuiImpl.class)
            .implement(LevelSelectGui.class, LevelSelectGuiImpl.class)
            .build(GuiFactory.class));
    }
}
