package com.tsioni.balloonadventure.impl;

import com.badlogic.gdx.Game;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.screen.api.ScreenFactory;

class BalloonAdventure extends Game
{
    private final ScreenFactory screenFactory;

    @Inject
    public BalloonAdventure(
        final ScreenFactory screenFactory)
    {
        this.screenFactory = screenFactory;
    }

    @Override
    public void create()
    {
        this.setScreen(screenFactory.createLevelLoadingScreen(new LevelId("1")));
    }
}
