package com.tsioni.balloonadventure.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.impl.GameInternalModule;
import com.tsioni.balloonadventure.screen.guice.ScreenModule;

public class GameModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new ScreenModule());

        install(new GameInternalModule());
    }
}
