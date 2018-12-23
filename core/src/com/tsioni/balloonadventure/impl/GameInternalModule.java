package com.tsioni.balloonadventure.impl;

import com.badlogic.gdx.Game;
import com.google.inject.AbstractModule;

public class GameInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Game.class).to(BalloonAdventure.class);
    }
}
