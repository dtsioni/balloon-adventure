package com.tsioni.balloonadventure.screen.impl;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.gui.api.GuiFactory;
import com.tsioni.balloonadventure.gui.api.LevelSelectGui;
import com.tsioni.balloonadventure.screen.api.ScreenFactory;
import com.tsioni.balloonadventure.screen.api.ScreenSetter;

class LevelSelectScreen implements Screen
{
    private final Batch batch;
    private final ScreenFactory screenFactory;
    private final ScreenSetter screenSetter;
    private final LevelSelectGui levelSelectGui;

    @Inject
    LevelSelectScreen(
        @Assisted final Batch batch,
        final ScreenFactory screenFactory,
        final ScreenSetter screenSetter,
        final GuiFactory guiFactory)
    {
        this.batch = batch;
        this.screenFactory = screenFactory;
        this.screenSetter = screenSetter;
        this.levelSelectGui = guiFactory.createLevelSelectGui(batch);
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(
        final float delta)
    {
        levelSelectGui.step(delta);
        levelSelectGui.draw();

        if (levelSelectGui.getSelectedLevelId().isPresent())
        {
            screenSetter.setScreen(screenFactory.createLevelLoadingScreen(
                batch,
                levelSelectGui.getSelectedLevelId().get()));
        }
    }

    @Override
    public void resize(
        final int width,
        final int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
