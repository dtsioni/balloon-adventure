package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BalloonActorInputListener extends InputListener
{
    public BalloonActorInputListener(BalloonEntityImpl.BalloonActor balloon)
    {
        this.balloon = balloon;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
    {
        return balloon.touchDown();
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button)
    {
        balloon.touchUp();
    }

    private BalloonEntityImpl.BalloonActor balloon;
}
