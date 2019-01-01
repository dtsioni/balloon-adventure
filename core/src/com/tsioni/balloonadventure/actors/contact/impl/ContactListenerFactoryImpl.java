package com.tsioni.balloonadventure.actors.contact.impl;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.tsioni.balloonadventure.actors.api.Entity;
import com.tsioni.balloonadventure.actors.contact.api.AbstractBaseContactListener;
import com.tsioni.balloonadventure.actors.contact.api.ContactListenerFactory;

class ContactListenerFactoryImpl implements ContactListenerFactory
{
    @Override
    public ContactListener createEntityContactListener(
        final Entity contactSubject)
    {
        /**
         * TODO: Handle other contact cases when they are needed.
         */
        return new AbstractBaseContactListener()
        {
            @Override
            public void beginContact(
                final Contact contact)
            {
                final Entity entityA = (Entity) contact.getFixtureA().getBody().getUserData();
                final Entity entityB = (Entity) contact.getFixtureB().getBody().getUserData();

                if (entityA == contactSubject)
                {
                    contactSubject.getEntityContactHandler().beginContact(entityB);
                }
                else if (entityB == contactSubject)
                {
                    contactSubject.getEntityContactHandler().beginContact(entityA);
                }
            }

            @Override
            public void endContact(
                final Contact contact)
            {
                final Entity entityA = (Entity) contact.getFixtureA().getBody().getUserData();
                final Entity entityB = (Entity) contact.getFixtureB().getBody().getUserData();

                if (entityA == contactSubject)
                {
                    contactSubject.getEntityContactHandler().endContact(entityB);
                }
                else if (entityB == contactSubject)
                {
                    contactSubject.getEntityContactHandler().endContact(entityA);
                }
            }
        };
    }
}
