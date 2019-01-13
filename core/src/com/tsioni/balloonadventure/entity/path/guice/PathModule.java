package com.tsioni.balloonadventure.entity.path.guice;

import com.google.inject.AbstractModule;
import com.tsioni.balloonadventure.entity.path.impl.PathInternalModule;

public class PathModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new PathInternalModule());
    }
}
