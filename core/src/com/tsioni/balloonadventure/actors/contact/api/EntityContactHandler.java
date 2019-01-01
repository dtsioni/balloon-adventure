package com.tsioni.balloonadventure.actors.contact.api;

import com.tsioni.balloonadventure.actors.api.Entity;

/**
 * Handle contact with another Entity.
 */
public interface EntityContactHandler
{
    void beginContact(Entity entity);

    void endContact(Entity entity);
}
