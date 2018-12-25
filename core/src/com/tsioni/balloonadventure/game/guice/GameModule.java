package com.tsioni.balloonadventure.game.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.game.impl.GameInternalModule;
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
