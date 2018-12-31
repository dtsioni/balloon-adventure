package com.tsioni.balloonadventure.actors.impl;

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

    class WindActor extends Actor
    {
        @Override
        public void act(float delta)
        {

        }
    }
}
