package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.Contact;
import com.tsioni.balloonadventure.actors.api.EntityId;
import com.tsioni.balloonadventure.actors.contact.api.AbstractBaseContactListener;
import com.tsioni.balloonadventure.debug.Debug;

import java.util.ArrayList;
import java.util.List;

class WindEntityContactListener extends AbstractBaseContactListener
{
    @Override
    public void beginContact(
        final Contact contact)
    {
        final List<EntityId> entityIdList = new ArrayList<EntityId>();

        entityIdList.add((EntityId) contact.getFixtureA().getBody().getUserData());
        entityIdList.add((EntityId) contact.getFixtureB().getBody().getUserData());

        Debug.out.println(entityIdList.get(0) + ", " + entityIdList.get(1));
    }
}
