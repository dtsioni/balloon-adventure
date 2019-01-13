package com.tsioni.balloonadventure.gui.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.tsioni.balloonadventure.gui.api.LevelTheaterGuiFactory;

public class GuiInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(LevelTheaterGuiFactory.class)
            .to(LevelTheaterGuiFactoryImpl.class)
            .in(Scopes.SINGLETON);
    }
}
