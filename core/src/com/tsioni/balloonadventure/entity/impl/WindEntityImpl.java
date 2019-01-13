package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.actor.AbstractBaseActor;
import com.tsioni.balloonadventure.entity.api.AbstractBaseEntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.AbstractBaseEntityVisitor;
import com.tsioni.balloonadventure.entity.api.BalloonEntity;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.EntityVisitor;
import com.tsioni.balloonadventure.entity.api.WindEntity;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.entity.api.WindEntityDefinition;
import com.tsioni.balloonadventure.util.api.Optional;

class WindEntityImpl implements WindEntity
{
    private final Actor actor;
    private final Body body;
    private final int direction;
    private final float FORCE_IMPULSE = 300;
    private final float degreesToRadians = 0.0174533f;

    private Optional<BalloonEntity> blowingBalloon = Optional.empty();

    WindEntityImpl(
        final Body body,
        final int direction)
    {
        this.body = body;
        this.direction = direction;
        this.actor = new WindActor();
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.of(actor);
    }

    @Override
    public EntityVisitor getEntityContactBeginVisitor()
    {
        return new AbstractBaseEntityVisitor()
        {
            @Override
            public void visit(final BalloonEntity balloonEntity)
            {
                Debug.out.println("Wind begin contact with: " + balloonEntity);

                blowingBalloon = Optional.of(balloonEntity);
            }
        };
    }

    @Override
    public EntityVisitor getEntityContactEndVisitor()
    {
        return new AbstractBaseEntityVisitor()
        {
            @Override
            public void visit(final BalloonEntity balloonEntity)
            {
                Debug.out.println("Wind end contact with: " + balloonEntity);

                blowingBalloon = Optional.empty();
            }
        };
    }

    @Override
    public EntityDefinitionVisitor getEntityDefinitionStateSetterVisitor()
    {
        return new AbstractBaseEntityDefinitionVisitor()
        {
            @Override
            public void visit(final WindEntityDefinition windEntityDefinition)
            {
                body.setTransform(new Vector2(
                    windEntityDefinition.getX(), windEntityDefinition.getY()), direction * degreesToRadians);

                body.setLinearVelocity(new Vector2(0, 0));
                body.setAngularVelocity(0);

                blowingBalloon = Optional.empty();
            }
        };
    }

    @Override
    public void hostVisitor(final EntityVisitor visitor)
    {
        visitor.visit(this);
    }

    class WindActor extends AbstractBaseActor
    {
        WindActor()
        {
            super();
            setRotation(direction);
        }

        @Override
        public void act(float delta)
        {
            if (blowingBalloon.isPresent())
            {
                final Vector2 blowVector = new Vector2(
                    (float) Math.cos(direction * degreesToRadians) * FORCE_IMPULSE,
                    (float) Math.sin(direction * degreesToRadians) * FORCE_IMPULSE);
                blowingBalloon.get().blowBalloon(blowVector);
            }
        }

        @Override
        protected String getImgPath()
        {
            return "core/assets/img/arrows.png";
        }

        @Override
        protected float getActorWidth()
        {
            return 8;
        }

        @Override
        protected float getActorHeight()
        {
            return 8;
        }

        @Override
        protected Body getBody()
        {
            return body;
        }
    }
}
