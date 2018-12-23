package com.tsioni.balloonadventure.screen.guice;

import com.badlogic.gdx.Screen;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.tsioni.balloonadventure.screen.api.LevelTheaterScreenFactory;
import com.tsioni.balloonadventure.screen.impl.LevelTheaterScreen;

public class LevelTheaterScreenModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new FactoryModuleBuilder()
            .implement(Screen.class, LevelTheaterScreen.class)
            .build(LevelTheaterScreenFactory.class));
    }
}
