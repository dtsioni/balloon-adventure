package com.tsioni.balloonadventure.entity.path.impl;

import com.badlogic.gdx.math.Vector2;
import com.tsioni.balloonadventure.entity.path.api.StraightPatrolPath;

import static java.lang.Math.sin;

class StraightPatrolPathImpl implements StraightPatrolPath
{
    private final float startPositionX;
    private final float startPositionY;
    private final float distanceX;
    private final float distanceY;
    private final float period;
    private final long startTime;

    public StraightPatrolPathImpl(final Vector2 startPosition,
                                  final Vector2 endPosition,
                                  final float period)
    {
        this.startPositionX = startPosition.x;
        this.startPositionY = startPosition.y;
        this.distanceX = endPosition.x - startPosition.x;
        this.distanceY = endPosition.y - startPosition.y;
        this.period = period;
        startTime = System.currentTimeMillis();
    }

    @Override
    public float getX()
    {
        final long deltaT = System.currentTimeMillis() - startTime;
        return startPositionX + ( distanceX * pulse(deltaT) );
    }

    @Override
    public float getY()
    {
        final long deltaT = System.currentTimeMillis() - startTime;
        return startPositionY + ( distanceY * pulse(deltaT) );
    }

    // Oscillates between 0 and 1.
    private float pulse(float time)
    {
        return (float) (0.5 * ( 1 + sin(time/(175 * period))));
    }
}
