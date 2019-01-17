package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Screen;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import com.tsioni.balloonadventure.screen.api.ScreenFactory;
import com.tsioni.balloonadventure.screen.api.ScreenSetter;
import com.tsioni.balloonadventure.screen.api.Screens;

public class ScreenInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(ScreenSetter.class).to(ScreenSetterImpl.class).in(Scopes.SINGLETON);

        install(new FactoryModuleBuilder()
            .implement(Screen.class, Names.named(Screens.LEVEL_LOADING_SCREEN), LevelLoadingScreen.class)
            .implement(Screen.class, Names.named(Screens.LEVEL_THEATER_SCREEN), LevelTheaterScreen.class)
            .implement(Screen.class, Names.named(Screens.LEVEL_SELECT_SCREEN), LevelSelectScreen.class)
            .build(ScreenFactory.class));
    }
}
