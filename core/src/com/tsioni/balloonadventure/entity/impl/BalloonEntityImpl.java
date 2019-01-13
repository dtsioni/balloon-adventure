package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.api.*;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;
import com.tsioni.balloonadventure.util.api.Optional;

class BalloonEntityImpl implements BalloonEntity
{
    private final Actor actor;
    private final Body body;
    private final LevelGameState levelGameState;

    BalloonEntityImpl(
        final Body body,
        final LevelGameState levelGameState)
    {
        this.actor = new BalloonActor();
        this.body = body;
        this.levelGameState = levelGameState;
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
            public void visit(final GoalEntity goalEntity)
            {
                goalEntity.collect();
            }

            @Override
            public void visit(final MinorGoalEntity minorGoalEntity)
            {
                minorGoalEntity.collect();
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
            public void visit(final BalloonEntityDefinition balloonEntityDefinition)
            {
                body.setTransform(new Vector2(
                    balloonEntityDefinition.getX(), balloonEntityDefinition.getY()), 0);

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

    @Override
    public void blowBalloon(final Vector2 blowVector)
    {
        body.applyForceToCenter(blowVector, true);
    }

    @Override
    public void killBalloon()
    {
        levelGameState.playerDied();
    }

    class BalloonActor extends Actor
    {
        private final float IMPULSE = 4;
        private final float FORCE_IMPULSE = 700;

        private final String IMG_PATH = "core/assets/img/balloon.png";
        private final Texture texture;
        private final TextureRegion textureRegion;

        private boolean isTouched;

        BalloonActor()
        {
            texture = new Texture(IMG_PATH);
            textureRegion = new TextureRegion(texture);
            setWidth(32);
            setHeight(32);

            this.addListener(new BalloonActorInputListener(this));
        }

        @Override
        public void draw(final Batch batch, final float alpha)
        {
            batch.draw(
                textureRegion,
                getX() - getOriginX(),
                getY() - getOriginY(),
                getOriginX(),
                getOriginY(),
                getWidth(),
                getHeight(),
                getScaleX(),
                getScaleY(),
                getRotation());
        }

        @Override
        public void act(final float delta)
        {
            if (isTouched)
            {
                if (body.getLinearVelocity().y < 0)
                {
                    body.setLinearVelocity(body.getLinearVelocity().x, body.getLinearVelocity().y + IMPULSE);
                }
                else
                {
                    body.applyForceToCenter(0, FORCE_IMPULSE, true);
                }
            }
        }

        public boolean touchDown()
        {
            return isTouched = true;
        }

        public void touchUp()
        {
            isTouched = false;
        }

        public float getX()
        {
            return body.getPosition().x;
        }

        public float getY()
        {
            return body.getPosition().y;
        }

        @Override
        public Actor hit(final float x, final float y, final boolean touchable)
        {
            return this;
        }
    }
}
