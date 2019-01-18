package com.tsioni.balloonadventure.entity.path.api;

import com.tsioni.balloonadventure.Steppable;

/**
 * Path will give an entity it's location on the path it is following. Stepping a path advances the
 * thing's point along the path.
 */
public interface Path extends Steppable
{
    float getX();
    float getY();
}
