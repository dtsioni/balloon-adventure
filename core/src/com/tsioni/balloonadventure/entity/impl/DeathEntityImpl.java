package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.actor.AbstractBaseActor;
import com.tsioni.balloonadventure.entity.api.*;
import com.tsioni.balloonadventure.util.api.Optional;

class DeathEntityImpl implements DeathEntity
{
    protected final Body body;

    DeathEntityImpl(
        final Body body)
    {
        this.body = body;
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.of(new DeathActor());
    }

    @Override
    public EntityVisitor getEntityContactBeginVisitor()
    {
        return new AbstractBaseEntityVisitor()
        {
            @Override
            public void visit(final BalloonEntity balloonEntity)
            {
                balloonEntity.killBalloon();
            }
        };
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
            public void visit(final DeathEntityDefinition deathEntityDefinition)
            {
                body.setTransform(new Vector2(
                    deathEntityDefinition.getX(), deathEntityDefinition.getY()), 0);

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

    class DeathActor extends AbstractBaseActor
    {
        @Override
        protected String getImgPath()
        {
            return "core/assets/img/mine.png";
        }

        @Override
        protected float getActorWidth()
        {
            return 16;
        }

        @Override
        protected float getActorHeight()
        {
            return 16;
        }

        @Override
        protected Body getBody()
        {
            return body;
        }
    }
}
