package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.actor.AbstractBaseActor;
import com.tsioni.balloonadventure.entity.api.*;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;
import com.tsioni.balloonadventure.util.api.Optional;

class GoalEntityImpl implements GoalEntity
{
    private final Body body;
    private final LevelGameState levelGameState;

    private boolean isCollected;

    GoalEntityImpl(
        final Body body,
        final LevelGameState levelGameState,
        final boolean isCollected)
    {
        this.body = body;
        this.levelGameState = levelGameState;
        this.isCollected = isCollected;
    }

    @Override
    public void collect()
    {
        if(!isCollected)
        {
            isCollected = true;
            levelGameState.playerCollectedAGoal();
        }
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.of(new GoalActor());
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
            public void visit(final GoalEntityDefinition goalEntityDefinition)
            {
                body.setTransform(new Vector2(
                    goalEntityDefinition.getX(), goalEntityDefinition.getY()), 0);

                body.setLinearVelocity(new Vector2(0, 0));
                body.setAngularVelocity(0);

                isCollected = goalEntityDefinition.isCollected();
            }
        };
    }

    @Override
    public void hostVisitor(final EntityVisitor visitor)
    {
        visitor.visit(this);
    }

    class GoalActor extends AbstractBaseActor
    {
        @Override
        protected String getImgPath()
        {
            return "core/assets/img/goldStar.png";
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
