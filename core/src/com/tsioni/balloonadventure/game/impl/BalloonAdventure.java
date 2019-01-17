package com.tsioni.balloonadventure.game.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.google.inject.Inject;

import com.google.inject.Injector;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.screen.api.ScreenFactory;

class BalloonAdventure extends Game
{
    private final Injector injector;
    private final ScreenFactory screenFactory;

    private Debug debug;

    @Inject
    public BalloonAdventure(
        final Injector injector,
        final ScreenFactory screenFactory)
    {
        this.injector = injector;
        this.screenFactory = screenFactory;
    }

    @Override
    public void create()
    {
        Debug.out.println("Starting Balloon Adventure...");

        /**
         * Including this here to ensure that Debug is instantiated first thing, so that it's input
         * processor is registered early, and so that it is available for drawing at the Game level.
         *
         * We have to ask for this instance after create() is called (instead of injecting it), to
         * ensure that the SpriteBatch is ready to be used.
         */
        this.debug = injector.getInstance(Debug.class);

        this.setScreen(screenFactory.createLevelSelectScreen());
    }

    @Override
    public void render ()
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
        debug.draw();
    }
}
