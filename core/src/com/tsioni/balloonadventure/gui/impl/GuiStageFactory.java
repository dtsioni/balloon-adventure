package com.tsioni.balloonadventure.gui.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * A helper class for creating a GUI stage which draws to the given Batch.
 *
 * A GUI stage is a stage which fills the screen and whose camera never moves.
 */
class GuiStageFactory
{
    private final Camera guiCamera = new OrthographicCamera();
    {
        guiCamera.combined.setToOrtho2D(
            0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    private final int screenWidth = Gdx.graphics.getWidth();
    private final int screenHeight = Gdx.graphics.getHeight();
    private final double aspectRatio = (double) screenWidth / screenHeight;
    private final int viewportWidth = 1024;
    // viewport aspect ratio should be the same as the screen aspect ratio
    private final int viewportHeight = (int) (viewportWidth / aspectRatio);

    private final FitViewport fitViewport =
        new FitViewport(viewportWidth, viewportHeight, guiCamera);

    Stage createGuiStage(
        final Batch batch)
    {
        return new Stage(fitViewport, batch);
    }
}
