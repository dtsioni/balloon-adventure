package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.Entity;
import com.tsioni.balloonadventure.util.api.Optional;

public class BalloonEntity implements Entity
{
    private final Body body;

    BalloonEntity(
        final Body body)
    {
        this.body = body;
    }

    @Override
    public Actor getActor()
    {
        return new BalloonActor();
    }

    @Override
    public Optional<Body> getBody()
    {
        return Optional.of(body);
    }

    class BalloonActor extends Actor
    {
        public float getX()
        {
            return getBody().get().getPosition().x;
        }
    }
}
