package com.tsioni.balloonadventure.entity.body.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.tsioni.balloonadventure.entity.body.api.BodyFactory;

public class BodyFactoryInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(BodyFactory.class).to(BodyFactoryImpl.class).in(Scopes.SINGLETON);
    }
}
