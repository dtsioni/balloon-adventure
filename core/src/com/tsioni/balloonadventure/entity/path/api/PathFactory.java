package com.tsioni.balloonadventure.entity.path.api;

import com.badlogic.gdx.math.Vector2;

public interface PathFactory
{
    Path createStraightPatrolPath(Vector2 startPosition, Vector2 endPosition, float period);
}
