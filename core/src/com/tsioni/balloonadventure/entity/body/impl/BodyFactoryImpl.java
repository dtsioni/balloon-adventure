package com.tsioni.balloonadventure.entity.body.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.tsioni.balloonadventure.entity.body.api.BodyFactory;

class BodyFactoryImpl implements BodyFactory
{
    @Override
    public Body createCircleShapeBody(
        World world,
        boolean isSensor,
        float density,
        float friction,
        float restitution,
        float width,
        BodyDef.BodyType bodyType)
    {
        final BodyDef bodyDef = new BodyDef();
        final FixtureDef fixtureDef = new FixtureDef();
        final CircleShape shape = new CircleShape();

        bodyDef.type = bodyType;
        bodyDef.fixedRotation = true;

        shape.setRadius(width/2f);

        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;
        fixtureDef.isSensor = isSensor;

        final Body body = world.createBody(bodyDef);

        body.createFixture(fixtureDef);

        return body;
    }

    @Override
    public Body createBoxShapeBody(
        final World world,
        final boolean isSensor,
        final float density,
        final float friction,
        final float restitution,
        final float width,
        final BodyDef.BodyType bodyType)
    {
        final BodyDef bodyDef = new BodyDef();
        final FixtureDef fixtureDef = new FixtureDef();
        final PolygonShape shape = new PolygonShape();

        bodyDef.type = bodyType;
        bodyDef.fixedRotation = true;

        shape.setAsBox(width / 2.0f, width / 2.0f);

        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;
        fixtureDef.isSensor = isSensor;

        final Body body = world.createBody(bodyDef);

        body.createFixture(fixtureDef);

        return body;
    }
}
