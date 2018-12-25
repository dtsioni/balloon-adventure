package com.tsioni.balloonadventure.game.impl;

import com.badlogic.gdx.Game;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class GameInternalModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Game.class).to(BalloonAdventure.class).in(Scopes.SINGLETON);
    }
}
