package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.actor.AbstractBaseActor;
import com.tsioni.balloonadventure.entity.api.*;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;
import com.tsioni.balloonadventure.util.api.Optional;

class MinorGoalEntityImpl implements MinorGoalEntity
{
    private final Body body;
    private final LevelGameState levelGameState;

    private boolean isCollected;

    MinorGoalEntityImpl(
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
            levelGameState.playerCollectedAMinorGoal();
        }
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.of(new MinorGoalActor());
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
            public void visit(final MinorGoalEntityDefinition minorGoalEntityDefinition)
            {
                body.setTransform(new Vector2(
                    minorGoalEntityDefinition.getX(), minorGoalEntityDefinition.getY()), 0);

                body.setLinearVelocity(new Vector2(0, 0));
                body.setAngularVelocity(0);

                isCollected = minorGoalEntityDefinition.isCollected();
            }
        };
    }

    @Override
    public void hostVisitor(final EntityVisitor visitor)
    {
        visitor.visit(this);
    }

    class MinorGoalActor extends AbstractBaseActor
    {
        @Override
        protected String getImgPath()
        {
            return "core/assets/img/silverStar.png";
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

        @Override
        public void draw(Batch batch, float alpha)
        {
            if(!isCollected)
            {
                super.draw(batch, alpha);
            }
        }
    }
}
