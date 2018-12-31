package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.Entity;
import com.tsioni.balloonadventure.actors.api.EntityId;
import com.tsioni.balloonadventure.util.api.Optional;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: This should be package-private
 */
public class BalloonEntity implements Entity
{
    private final Actor actor;
    private final Body body;
    private final int layerId;

    BalloonEntity(
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

    static class BalloonContactListener implements ContactListener
    {
        @Override
        public void beginContact(
            final Contact contact)
        {
            final List<EntityId> entityIdList = new ArrayList<EntityId>();

            entityIdList.add((EntityId) contact.getFixtureA().getBody().getUserData());
            entityIdList.add((EntityId) contact.getFixtureB().getBody().getUserData());

            System.out.println(entityIdList.get(0) + ", " + entityIdList.get(1));
        }

        @Override
        public void endContact(
            final Contact contact)
        {

        }

        @Override
        public void preSolve(
            final Contact contact,
            final Manifold oldManifold)
        {

        }

        @Override
        public void postSolve(
            final Contact contact,
            final ContactImpulse impulse)
        {

        }
    }
}
