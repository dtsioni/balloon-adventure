package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.Entity;
import com.tsioni.balloonadventure.util.api.Optional;

class SquareWallEntity implements Entity
{
    @Override
    public Actor getActor()
    {
        return null;
    }

    @Override
    public Optional<Body> getBody()
    {
        return null;
    }

    @Override
    public int getLayerId()
    {
        return 0;
    }
}
