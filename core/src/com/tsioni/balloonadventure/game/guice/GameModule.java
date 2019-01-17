package com.tsioni.balloonadventure.game.guice;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.game.impl.GameInternalModule;
import com.tsioni.balloonadventure.input.api.InputProcessorRegistry;
import com.tsioni.balloonadventure.screen.guice.ScreenModule;

public class GameModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        install(new ScreenModule());

        install(new GameInternalModule());
    }

    @Provides
    @Singleton
    public Batch provideBatch()
    {
        return new SpriteBatch();
    }

    @Provides
    @Singleton
    public Debug provideDebug(
        final Batch batch,
        final InputProcessorRegistry inputProcessorRegistry)
    {
        return new Debug(batch, inputProcessorRegistry);
    }
}
