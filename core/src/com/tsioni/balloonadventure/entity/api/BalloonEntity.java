package com.tsioni.balloonadventure.entity.api;

import com.badlogic.gdx.math.Vector2;

public interface BalloonEntity extends Entity
{
    /**
     * Blow the balloon using the provided force vector.
     */
    void blowBalloon(Vector2 blowVector);

    /**
     * Kill the balloon.
     */
    void killBalloon();
}
