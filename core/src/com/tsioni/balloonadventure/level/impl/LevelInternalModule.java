package com.tsioni.balloonadventure.level.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.tsioni.balloonadventure.level.api.LevelDeserializer;
import com.tsioni.balloonadventure.level.api.LevelFetcher;
import com.tsioni.balloonadventure.level.api.LevelTheaterGenerator;

public class LevelInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(LevelTheaterGenerator.class).to(LevelTheaterGeneratorImpl.class).in(Scopes.SINGLETON);
        bind(LevelFetcher.class).to(LevelFetcherImpl.class).in(Scopes.SINGLETON);
        bind(LevelDeserializer.class).to(LevelDeserializerImpl.class).in(Scopes.SINGLETON);
    }
}
