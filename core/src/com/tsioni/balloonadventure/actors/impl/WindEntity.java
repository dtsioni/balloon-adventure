package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.Entity;
import com.tsioni.balloonadventure.actors.contact.api.EntityContactHandler;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.util.api.Optional;

class WindEntity implements Entity
{
    private final Actor actor;
    private final Body body;
    private final int layerId;
    private final float FORCE_IMPULSE = 50;

    private boolean isBlowing;
    private Entity blowee;

    WindEntity(
        final Body body,
        final int layerId)
    {
        this.actor = new WindActor();
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
    public EntityContactHandler getEntityContactHandler()
    {
        return new EntityContactHandler()
        {
            @Override
            public void beginContact(
                final Entity entity)
            {
                Debug.out.println("Wind begin contact with: " + entity);

                if (entity.getBody().isPresent())
                {
                    isBlowing = true;
                    blowee = entity;
                }
            }

            @Override
            public void endContact(
                final Entity entity)
            {
                Debug.out.println("Wind end contact with: " + entity);

                if (blowee == entity)
                {
                    isBlowing = false;
                    blowee = null;
                }
            }
        };
    }

    class WindActor extends Actor
    {
        @Override
        public void act(float delta)
        {
            if (isBlowing)
            {
                blowee.getBody().get().applyForceToCenter(FORCE_IMPULSE, 0, true);
            }
        }
    }
}
