package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.AbstractBaseEntityVisitor;
import com.tsioni.balloonadventure.actors.api.EntityVisitor;
import com.tsioni.balloonadventure.actors.api.SquareWallEntity;
import com.tsioni.balloonadventure.util.api.Optional;

class SquareWallEntityImpl implements SquareWallEntity
{
    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.empty();
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
