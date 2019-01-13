package com.tsioni.balloonadventure.entity.path.impl;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.entity.path.api.PathFactory;

public class PathInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(PathFactory.class).to(PathFactoryImpl.class);
    }
}
