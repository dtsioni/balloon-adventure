package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.actor.AbstractBaseActor;
import com.tsioni.balloonadventure.entity.api.*;
import com.tsioni.balloonadventure.entity.path.api.Path;
import com.tsioni.balloonadventure.entity.path.api.PathFactory;
import com.tsioni.balloonadventure.util.api.Optional;

class MovingPlatformEntityImpl implements MovingPlatformEntity
{
    private final Body body;
    private final int endX;
    private final int endY;
    private final int period;
    private final PathFactory pathFactory;
    private Path path;
    private Optional<BalloonEntity> touchingBalloon = Optional.empty();

    MovingPlatformEntityImpl(
        final Body body,
        final int endX,
        final int endY,
        final int period,
        final PathFactory pathFactory)
    {
        this.body = body;
        this.endX = endX;
        this.endY = endY;
        this.period = period;
        this.pathFactory = pathFactory;
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.of(new MovingPlatformActor());
    }

    @Override
    public EntityVisitor getEntityContactBeginVisitor()
    {
        return new AbstractBaseEntityVisitor(){
            @Override
            public void visit(final BalloonEntity balloonEntity)
            {
                touchingBalloon = Optional.of(balloonEntity);
            }
        };
    }

    @Override
    public EntityVisitor getEntityContactEndVisitor()
    {
        return new AbstractBaseEntityVisitor(){
            @Override
            public void visit(final BalloonEntity balloonEntity)
            {
                touchingBalloon = Optional.empty();
            }
        };
    }

    @Override
    public EntityDefinitionVisitor getEntityDefinitionStateSetterVisitor()
    {
        return new AbstractBaseEntityDefinitionVisitor()
        {
            @Override
            public void visit(final MovingPlatformEntityDefinition movingPlatformEntityDefinition)
            {
                body.setTransform(new Vector2(
                    movingPlatformEntityDefinition.getX(), movingPlatformEntityDefinition.getY()), 0);

                body.setLinearVelocity(new Vector2(0, 0));
                body.setAngularVelocity(0);

                path = pathFactory.createStraightPatrolPath(
                    new Vector2(movingPlatformEntityDefinition.getX(), movingPlatformEntityDefinition.getY()),
                    new Vector2(endX, endY),
                    period);
            }
        };
    }

    @Override
    public void hostVisitor(final EntityVisitor visitor)
    {
        visitor.visit(this);
    }

    class MovingPlatformActor extends AbstractBaseActor
    {
        @Override
        public void act(float delta)
        {
            path.step(delta);
            body.setLinearVelocity(path.getXVelocity(), path.getYVelocity());
            /** TODO Carry the balloon. This depends on paths being changed to set velocity instead of position */
        }
        @Override
        protected String getImgPath()
        {
            return "core/assets/img/squareWall.png";
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
