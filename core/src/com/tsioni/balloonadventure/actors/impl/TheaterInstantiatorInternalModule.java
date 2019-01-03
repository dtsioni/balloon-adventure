package com.tsioni.balloonadventure.actors.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.tsioni.balloonadventure.actors.api.*;

public class TheaterInstantiatorInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(EntityDefinitionLoader.class)
            .to(EntityDefinitionLoaderImpl.class)
            .in(Scopes.SINGLETON);

        bind(TiledMapEntityDefinitionsFactory.class)
            .to(TiledMapEntityDefinitionsFactoryImpl.class)
            .in(Scopes.SINGLETON);

        bind(EntityDefinitionFactory.class)
            .to(EntityDefinitionFactoryImpl.class)
            .in(Scopes.SINGLETON);

        install(new FactoryModuleBuilder()
            .implement(EntityDefinitionVisitor.class, TheaterInstantiatorEntityDefinitionVisitor.class)
            .build(TheaterInstantiatorFactory.class));
    }
}
