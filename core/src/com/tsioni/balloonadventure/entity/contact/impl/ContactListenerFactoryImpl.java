package com.tsioni.balloonadventure.entity.contact.impl;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.tsioni.balloonadventure.entity.api.Entity;
import com.tsioni.balloonadventure.entity.contact.api.ContactListenerFactory;

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
                    entityB.hostVisitor(entityA.getEntityContactBeginVisitor());
                }
                else if (entityB == contactSubject)
                {
                    entityA.hostVisitor(entityB.getEntityContactBeginVisitor());
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
                    entityB.hostVisitor(entityA.getEntityContactEndVisitor());
                }
                else if (entityB == contactSubject)
                {
                    entityA.hostVisitor(entityB.getEntityContactEndVisitor());
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
