package com.tsioni.balloonadventure.stage.impl;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tsioni.balloonadventure.input.AbstractBaseInputProcessor;

public class StageInputProcessorImpl extends AbstractBaseInputProcessor
{
    public StageInputProcessorImpl(Stage stage)
    {
        this.stage = stage;
    }

    @Override
    public boolean touchDown(
        int screenX,
        int screenY,
        int pointer,
        int button)
    {
        return stage.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(
        int screenX,
        int screenY,
        int pointer,
        int button)
    {
        return stage.touchUp(screenX, screenY, pointer, button);
    }

    private Stage stage;
}

