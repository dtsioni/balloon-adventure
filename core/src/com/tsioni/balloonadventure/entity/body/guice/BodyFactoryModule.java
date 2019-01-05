package com.tsioni.balloonadventure.entity.body.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.entity.body.impl.BodyFactoryInternalModule;

public class BodyFactoryModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new BodyFactoryInternalModule());
    }
}
