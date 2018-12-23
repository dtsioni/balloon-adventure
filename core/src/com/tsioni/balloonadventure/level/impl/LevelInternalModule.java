package com.tsioni.balloonadventure.level.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.tsioni.balloonadventure.level.api.LevelInitialStateFetcher;
import com.tsioni.balloonadventure.level.api.LevelTheaterGenerator;

public class LevelInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(LevelTheaterGenerator.class).to(LevelTheaterGeneratorImpl.class).in(Scopes.SINGLETON);
        bind(LevelInitialStateFetcher.class).to(LevelInitialStateFetcherImpl.class).in(Scopes.SINGLETON);
    }
}
