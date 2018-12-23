package com.tsioni.balloonadventure.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.impl.GameInternalModule;

public class GameModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new GameInternalModule());
    }
}
