package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.AbstractBaseEntityVisitor;
import com.tsioni.balloonadventure.actors.api.EntityVisitor;
import com.tsioni.balloonadventure.actors.api.SquareWallEntity;
import com.tsioni.balloonadventure.util.api.Optional;

class SquareWallEntityImpl implements SquareWallEntity
{
    private final Body body;
    private final int layerId;

    SquareWallEntityImpl(
        final Body body,
        final int layerId)
    {
        this.body = body;
        this.layerId = layerId;
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.empty();
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

    @Override
    public EntityVisitor getEntityContactBeginVisitor()
    {
        return new AbstractBaseEntityVisitor(){};
    }

    @Override
    public EntityVisitor getEntityContactEndVisitor()
    {
        return new AbstractBaseEntityVisitor(){};
    }

    @Override
    public void hostVisitor(final EntityVisitor visitor)
    {
        visitor.visit(this);
    }
}
