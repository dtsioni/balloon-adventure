package com.tsioni.balloonadventure.actors.contact.api;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This multiplexer will delegate a contact to many contact listeners.
 */
public class ContactListenerMultiplexer implements ContactListener
{
    final List<ContactListener> contactListenerMultiplex = new ArrayList<ContactListener>();

    public ContactListenerMultiplexer(
        final ContactListener... contactListeners)
    {
        contactListenerMultiplex.addAll(Arrays.asList(contactListeners));
    }

    @Override
    public void beginContact(
        final Contact contact)
    {
        forEachContactListener(new Consumer<ContactListener>()
        {
            @Override
            public void accept(final ContactListener contactListener)
            {
                contactListener.beginContact(contact);
            }
        });
    }

    @Override
    public void endContact(
        final Contact contact)
    {
        forEachContactListener(new Consumer<ContactListener>()
        {
            @Override
            public void accept(final ContactListener contactListener)
            {
                contactListener.endContact(contact);
            }
        });
    }

    @Override
    public void preSolve(
        final Contact contact,
        final Manifold oldManifold)
    {
        forEachContactListener(new Consumer<ContactListener>()
        {
            @Override
            public void accept(final ContactListener contactListener)
            {
                contactListener.preSolve(contact, oldManifold);
            }
        });
    }

    @Override
    public void postSolve(
        final Contact contact,
        final ContactImpulse impulse)
    {
        forEachContactListener(new Consumer<ContactListener>()
        {
            @Override
            public void accept(final ContactListener contactListener)
            {
                contactListener.postSolve(contact, impulse);
            }
        });
    }

    private void forEachContactListener(
        final Consumer<ContactListener> contactListenerConsumer)
    {
        for (final ContactListener contactListener : contactListenerMultiplex)
        {
            contactListenerConsumer.accept(contactListener);
        }
    }

    /**
     * TODO: Replace this when we have access to the Java 8 Stream APIs
     */
    interface Consumer<T>
    {
        void accept(T t);
    }
}
