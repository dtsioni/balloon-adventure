package com.tsioni.balloonadventure.entity.path.impl;

import com.badlogic.gdx.math.Vector2;
import com.tsioni.balloonadventure.entity.path.api.StraightPatrolPath;

class StraightPatrolPathImpl implements StraightPatrolPath
{
    private final float startPositionX;
    private final float startPositionY;
    private final float distanceX;
    private final float distanceY;
    private final float period;

    private float delta = 0;

    StraightPatrolPathImpl(
        final Vector2 startPosition,
        final Vector2 endPosition,
        final float period)
    {
        this.startPositionX = startPosition.x;
        this.startPositionY = startPosition.y;
        this.distanceX = endPosition.x - startPosition.x;
        this.distanceY = endPosition.y - startPosition.y;
        this.period = period;
    }

    @Override
    public float getX()
    {
        return startPositionX + (distanceX * pulse());
    }

    @Override
    public float getY()
    {
        return startPositionY + (distanceY * pulse());
    }

    // Oscillates between 0 and 1.
    private float pulse()
    {
        return 1 - (float) (0.5 * (1 + Math.cos(1000 * delta/(175 * period))));
    }

    @Override
    public void step(final float delta)
    {
        /**
         * Because this is essentially counting number of played milliseconds, I think that this
         * will only overflow in like 60 years, and at that point everyone will be playing
         * Balloon Adventure 4.
         */
        this.delta += delta;
    }
}
