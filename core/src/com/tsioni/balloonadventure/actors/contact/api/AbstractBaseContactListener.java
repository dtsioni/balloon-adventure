package com.tsioni.balloonadventure.actors.contact.api;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public abstract class AbstractBaseContactListener implements ContactListener
{
    @Override
    public void beginContact(
        final Contact contact)
    {

    }

    @Override
    public void endContact(
        final Contact contact)
    {

    }

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
}
