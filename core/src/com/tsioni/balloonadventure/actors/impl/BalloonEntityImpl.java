package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.AbstractBaseEntityVisitor;
import com.tsioni.balloonadventure.actors.api.BalloonEntity;
import com.tsioni.balloonadventure.actors.api.EntityVisitor;
import com.tsioni.balloonadventure.util.api.Optional;

class BalloonEntityImpl implements BalloonEntity
{
    private final Actor actor;
    private final Body body;
    private final int layerId;

    BalloonEntityImpl(
        final Body body,
        final int layerId)
    {
        this.actor = new BalloonActor();
        this.body = body;
        this.layerId = layerId;
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.of(actor);
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

    class BalloonActor extends Actor
    {
        BalloonActor()
        {
            texture = new Texture(IMG_PATH);
            textureRegion = new TextureRegion(texture);
            setWidth(32);
            setHeight(32);

            this.addListener(new BalloonActorInputListener(this));
        }

        @Override
        public void draw(Batch batch, float alpha)
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
        public void act(float delta)
        {
            if(isTouched)
            {
                if(getBody().get().getLinearVelocity().y < 0)
                {
                    getBody().get().setLinearVelocity(getBody().get().getLinearVelocity().x, getBody().get().getLinearVelocity().y + IMPULSE);
                }
                else
                {
                    getBody().get().applyForceToCenter(0, FORCE_IMPULSE, true);
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
            return getBody().get().getPosition().x;
        }

        public float getY()
        {
            return getBody().get().getPosition().y;
        }

        @Override
        public Actor hit(float x, float y, boolean touchable)
        {
            return this;
        }

        private boolean isTouched;

        private final float IMPULSE = 4;
        private final float FORCE_IMPULSE = 700;

        private final String IMG_PATH = "core/assets/img/balloon.png";
        private final Texture texture;
        private final TextureRegion textureRegion;
    }
}
