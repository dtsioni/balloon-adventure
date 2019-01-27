package com.tsioni.balloonadventure.entity.path.api;

import com.tsioni.balloonadventure.Steppable;

/**
 * Path will give an entity it's velocity to follow a path.
 */
public interface Path extends Steppable
{
    float getXVelocity();
    float getYVelocity();
}
