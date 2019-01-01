package com.tsioni.balloonadventure.actors.contact.impl;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.tsioni.balloonadventure.actors.api.Entity;
import com.tsioni.balloonadventure.actors.contact.api.ContactListenerFactory;

class ContactListenerFactoryImpl implements ContactListenerFactory
{
    @Override
    public ContactListener createEntityContactListener(
        final Entity contactSubject)
    {
        return new ContactListener()
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

            /**
             * TODO: Handle these when they are needed.
             */
            @Override
            public void preSolve(
                final Contact contact,
                final Manifold oldManifold)
            {

            }

            @Override
            public void postSolve(
                final Contact contact,
                final ContactImpulse impulse)
            {

            }
        };
    }
}
