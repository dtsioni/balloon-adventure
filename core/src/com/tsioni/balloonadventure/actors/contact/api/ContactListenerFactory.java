package com.tsioni.balloonadventure.actors.contact.api;

import com.badlogic.gdx.physics.box2d.ContactListener;
import com.tsioni.balloonadventure.actors.api.Entity;

public interface ContactListenerFactory
{
    /**
     * Create a contact listener which listens for contacts on the subject Entity and which handles
     * any corresponding object Entities with the subject Entities contact visitors.
     */
    ContactListener createEntityContactListener(Entity contactSubject);
}
