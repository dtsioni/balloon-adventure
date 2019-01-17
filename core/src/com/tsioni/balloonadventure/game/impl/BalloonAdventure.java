package com.tsioni.balloonadventure.game.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.inject.Inject;
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
        this.setScreen(screenFactory.createLevelSelectScreen(new SpriteBatch()));
    }
}
