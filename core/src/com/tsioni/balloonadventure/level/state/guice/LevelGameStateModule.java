package com.tsioni.balloonadventure.level.state.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.level.state.impl.LevelGameStateInternalModule;

public class LevelGameStateModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new LevelGameStateInternalModule());
    }
}
