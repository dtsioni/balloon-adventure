package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.actor.AbstractBaseActor;
import com.tsioni.balloonadventure.entity.api.*;
import com.tsioni.balloonadventure.util.api.Optional;

class SquareWallEntityImpl implements SquareWallEntity
{
    private final Body body;

    SquareWallEntityImpl(
        final Body body)
    {
        this.body = body;
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.of(new SquareWallActor());
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
    public EntityDefinitionVisitor getEntityDefinitionStateSetterVisitor()
    {
        return new AbstractBaseEntityDefinitionVisitor()
        {
            @Override
            public void visit(final SquareWallEntityDefinition squareWallEntityDefinition)
            {
                body.setTransform(new Vector2(
                    squareWallEntityDefinition.getX(), squareWallEntityDefinition.getY()), 0);

                body.setLinearVelocity(new Vector2(0, 0));
                body.setAngularVelocity(0);
            }
        };
    }

    @Override
    public void hostVisitor(final EntityVisitor visitor)
    {
        visitor.visit(this);
    }

    class SquareWallActor extends AbstractBaseActor
    {
        @Override
        protected String getImgPath()
        {
            return "core/assets/img/squareWall.jpg";
        }

        @Override
        protected float getActorWidth()
        {
            return 32;
        }

        @Override
        protected float getActorHeight()
        {
            return 32;
        }

        @Override
        protected Body getBody()
        {
            return body;
        }
    }
}
