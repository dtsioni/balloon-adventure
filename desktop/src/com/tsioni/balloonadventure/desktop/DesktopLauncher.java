package com.tsioni.balloonadventure.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.google.inject.Guice;
import com.tsioni.balloonadventure.game.guice.GameModule;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        final Game balloonAdventure = Guice.createInjector(new GameModule()).getInstance(Game.class);
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1000;
        config.height = 1000;
        new LwjglApplication(balloonAdventure, config);
    }
}

