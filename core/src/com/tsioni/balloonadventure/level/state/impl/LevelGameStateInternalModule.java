package com.tsioni.balloonadventure.level.state.impl;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;
import com.tsioni.balloonadventure.level.state.api.LevelGameStateFactory;

public class LevelGameStateInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new FactoryModuleBuilder()
            .implement(LevelGameState.class, LevelGameStateImpl.class)
            .build(LevelGameStateFactory.class));
    }
}
