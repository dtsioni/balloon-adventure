package com.tsioni.balloonadventure.input.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.input.impl.InputProcessorRegistryInternalModule;

public class InputProcessorRegistryModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new InputProcessorRegistryInternalModule());
    }
}
