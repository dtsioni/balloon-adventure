package com.tsioni.balloonadventure.actors.body.api;

import com.badlogic.gdx.physics.box2d.*;

public class BodyBuilder
{
    private World world;
    private Shape shape;
    private float density = 0f;
    private float friction = 0f;
    private float restitution = 0f;
    private BodyDef.BodyType bodyType;
    private boolean isSensor = false;
    private int rotation;
    private int x;
    private int y;
    private Object userData = null;

    private Body body;

    public BodyBuilder withType(BodyDef.BodyType type)
    {
        this.bodyType = type;
        return this;
    }

    public BodyBuilder withXPosition(int x)
    {
        this.x = x;
        return this;
    }

    public BodyBuilder withYPosition(int y)
    {
        this.y = y;
        return this;
    }

    public BodyBuilder withWorld(World world)
    {
        this.world = world;
        return this;
    }

    public BodyBuilder withShape(Shape shape)
    {
        this.shape = shape;
        return this;
    }

    public BodyBuilder withDensity(float d)
    {
        density = d;
        return this;
    }

    public BodyBuilder withFriction(float f)
    {
        friction = f;
        return this;
    }

    public BodyBuilder withRestitution(float r)
    {
        restitution = r;
        return this;
    }

    public BodyBuilder withIsSensor(boolean isSensor)
    {
        this.isSensor = isSensor;
        return this;
    }

    public BodyBuilder withUserData(Object userData)
    {
        this.userData = userData;
        return this;
    }

    public Body build()
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        bodyDef.position.set(x, y);
        bodyDef.fixedRotation = true;

        body = world.createBody(bodyDef);
        body.setUserData(userData);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;
        fixtureDef.isSensor = isSensor;

        Fixture fixture = body.createFixture(fixtureDef);

        return body;
    }
}
