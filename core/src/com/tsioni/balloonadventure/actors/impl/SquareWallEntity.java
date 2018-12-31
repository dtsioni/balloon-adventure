package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.Entity;
import com.tsioni.balloonadventure.util.api.Optional;

class SquareWallEntity implements Entity
{
    private final Body body;
    private final int layerId;

    SquareWallEntity(
        final Body body,
        final int layerId)
    {
        this.body = body;
        this.layerId = layerId;
    }

    @Override
    public Actor getActor()
    {
        return null;
    }

    @Override
    public Optional<Body> getBody()
    {
        return Optional.of(body);
    }

    @Override
    public int getLayerId()
    {
        return layerId;
    }
}
