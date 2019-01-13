package com.tsioni.balloonadventure.entity.path.impl;

import com.badlogic.gdx.math.Vector2;
import com.tsioni.balloonadventure.entity.path.api.Path;
import com.tsioni.balloonadventure.entity.path.api.PathFactory;

class PathFactoryImpl implements PathFactory
{
    @Override
    public Path createStraightPatrolPath(final Vector2 startPosition, final Vector2 endPosition, final float period)
    {
        return new StraightPatrolPathImpl(startPosition, endPosition, period);
    }
}
