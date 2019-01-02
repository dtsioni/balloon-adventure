package com.tsioni.balloonadventure.actors.api;

import com.badlogic.gdx.math.Vector2;

public interface BalloonEntity extends Entity
{
    /**
     * Blow the balloon using the provided force vector.
     */
    void blowBalloon(Vector2 blowVector);
}
