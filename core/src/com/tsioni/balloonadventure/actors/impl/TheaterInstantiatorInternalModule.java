package com.tsioni.balloonadventure.actors.impl;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.actors.api.TheaterInstantiatorFactory;

public class TheaterInstantiatorInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new FactoryModuleBuilder()
            .implement(EntityDefinitionVisitor.class, TheaterInstantiatorEntityDefinitionVisitor.class)
            .build(TheaterInstantiatorFactory.class));
    }
}
