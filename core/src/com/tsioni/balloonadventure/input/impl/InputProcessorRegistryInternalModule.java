package com.tsioni.balloonadventure.input.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.tsioni.balloonadventure.input.api.InputProcessorRegistry;

public class InputProcessorRegistryInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(InputProcessorRegistry.class)
            .to(LibgdxInputProcessorRegistry.class)
            .in(Scopes.SINGLETON);
    }
}
