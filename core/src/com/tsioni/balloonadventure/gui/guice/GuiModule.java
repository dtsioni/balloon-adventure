package com.tsioni.balloonadventure.gui.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.gui.impl.GuiInternalModule;

public class GuiModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new GuiInternalModule());
    }
}
