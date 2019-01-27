package com.tsioni.balloonadventure.entity.path.impl;

import com.badlogic.gdx.math.Vector2;
import com.tsioni.balloonadventure.entity.path.api.StraightPatrolPath;

class StraightPatrolPathImpl implements StraightPatrolPath
{
    private final float distanceX;
    private final float distanceY;
    private final float period;

    private float elapsedTime = 0;

    StraightPatrolPathImpl(
        final Vector2 startPosition,
        final Vector2 endPosition,
        final float period)
    {
        this.distanceX = endPosition.x - startPosition.x;
        this.distanceY = endPosition.y - startPosition.y;
        this.period = period;
    }

    @Override
    public float getXVelocity()
    {
        return (float) (Math.sin(elapsedTime * 2 * Math.PI / period) * distanceX * Math.PI / period);
    }

    @Override
    public float getYVelocity()
    {
        return (float) (Math.sin(elapsedTime * 2 * Math.PI / period) * distanceY * Math.PI / period);
    }

    @Override
    public void step(final float delta)
    {
        this.elapsedTime += delta;
    }
}
