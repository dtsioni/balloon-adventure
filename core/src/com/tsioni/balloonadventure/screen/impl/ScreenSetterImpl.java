package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.screen.api.ScreenSetter;

public class ScreenSetterImpl implements ScreenSetter
{
    private final Game game;

    @Inject
    ScreenSetterImpl(
        final Game game)
    {
        this.game = game;
    }

    @Override
    public void setScreen(final Screen screen)
    {
        game.setScreen(screen);
    }
}
