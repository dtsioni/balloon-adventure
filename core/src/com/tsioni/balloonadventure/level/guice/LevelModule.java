package com.tsioni.balloonadventure.level.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.entity.guice.TheaterInstantiatorModule;
import com.tsioni.balloonadventure.level.impl.LevelInternalModule;
import com.tsioni.balloonadventure.level.state.guice.LevelGameStateModule;

public class LevelModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new TheaterInstantiatorModule());
        install(new LevelGameStateModule());

        install(new LevelInternalModule());
    }
}
