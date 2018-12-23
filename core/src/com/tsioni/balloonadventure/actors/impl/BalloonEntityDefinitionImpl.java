package com.tsioni.balloonadventure.actors.impl;

import com.tsioni.balloonadventure.actors.api.*;

public class BalloonEntityDefinitionImpl implements BalloonEntityDefinition
{
    @Override
    public Box2dDefinition getBox2dDefinition()
    {
        return null;
    }

    @Override
    public EntityId getEntityId()
    {
        return null;
    }

    @Override
    public void hostVisitor(final EntityDefinitionVisitor visitor)
    {
        visitor.visit(this);
    }
}
