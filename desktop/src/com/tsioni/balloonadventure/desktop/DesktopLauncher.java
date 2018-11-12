package com.tsioni.balloonadventure.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tsioni.balloonadventure.BalloonAdventure;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new BalloonAdventure(), config);
    }
}

