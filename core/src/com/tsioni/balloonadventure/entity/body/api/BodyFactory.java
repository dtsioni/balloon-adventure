package com.tsioni.balloonadventure.entity.body.api;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public interface BodyFactory
{
    /**
     * @param isSensor A sensor can sense collisions with other bodies but won't stop their
     *                 movement.
     *
     * @return A single fixture circle shape body in the provided world.
     */
    Body createCircleShapeBody(
        World world,
        boolean isSensor,
        float density,
        float friction,
        float restitution,
        float width,
        BodyDef.BodyType bodyType,
        int x,
        int y);

    /**
     * @param isSensor A sensor can sense collisions with other bodies but won't stop their
     *                 movement.
     *
     * @return A single fixture box shape body in the provided world.
     *
     */
    Body createBoxShapeBody(
        World world,
        boolean isSensor,
        float density,
        float friction,
        float restitution,
        float width,
        BodyDef.BodyType bodyType,
        int x,
        int y);
}
