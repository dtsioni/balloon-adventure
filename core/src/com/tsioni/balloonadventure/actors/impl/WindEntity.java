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
            }

            @Override
            public void endContact(
                final Entity entity)
            {
                Debug.out.println("Wind end contact with: " + entity);
            }
        };
    }

    class WindActor extends Actor
    {
        @Override
        public void act(float delta)
        {

        }
    }
}
