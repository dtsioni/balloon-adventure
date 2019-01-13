package com.tsioni.balloonadventure.screen.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.gui.guice.GuiModule;
import com.tsioni.balloonadventure.level.guice.LevelModule;
import com.tsioni.balloonadventure.screen.impl.ScreenInternalModule;

public class ScreenModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new LevelModule());
        install(new GuiModule());

        install(new ScreenInternalModule());
    }
}
