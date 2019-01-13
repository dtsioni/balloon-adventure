package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.actor.AbstractBaseActor;
import com.tsioni.balloonadventure.entity.api.AbstractBaseEntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.MovingDeathEntity;
import com.tsioni.balloonadventure.entity.api.MovingDeathEntityDefinition;
import com.tsioni.balloonadventure.entity.path.api.Path;
import com.tsioni.balloonadventure.entity.path.api.PathFactory;
import com.tsioni.balloonadventure.util.api.Optional;

public class MovingDeathEntityImpl extends DeathEntityImpl implements MovingDeathEntity
{
    private final int endX;
    private final int endY;
    private final int period;
    private final PathFactory pathFactory;
    private Path path;

    MovingDeathEntityImpl(
        final Body body,
        final int endX,
        final int endY,
        final int period,
        final PathFactory pathFactory)
    {
        super(body);
        this.endX = endX;
        this.endY = endY;
        this.period = period;
        this.pathFactory = pathFactory;
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.of(new MovingDeathActor());
    }

    @Override
    public EntityDefinitionVisitor getEntityDefinitionStateSetterVisitor()
    {
        return new AbstractBaseEntityDefinitionVisitor()
        {
            @Override
            public void visit(final MovingDeathEntityDefinition movingDeathEntityDefinition)
            {
                body.setTransform(new Vector2(
                    movingDeathEntityDefinition.getX(), movingDeathEntityDefinition.getY()), 0);

                body.setLinearVelocity(new Vector2(0, 0));
                body.setAngularVelocity(0);

                path = pathFactory.createStraightPatrolPath(
                    new Vector2(movingDeathEntityDefinition.getX(), movingDeathEntityDefinition.getY()),
                    new Vector2(endX, endY),
                    period);
            }
        };
    }

    class MovingDeathActor extends AbstractBaseActor
    {
        @Override
        public void act(float delta)
        {
            body.setTransform(path.getX(), path.getY(), body.getAngle());
        }

        @Override
        protected String getImgPath()
        {
            return "core/assets/img/mine.png";
        }

        @Override
        protected float getActorWidth()
        {
            return 4;
        }

        @Override
        protected float getActorHeight()
        {
            return 4;
        }

        @Override
        protected Body getBody()
        {
            return body;
        }
    }
}
