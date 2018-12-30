package com.tsioni.balloonadventure.actors.impl;

import com.tsioni.balloonadventure.actors.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.actors.api.EntityId;
import com.tsioni.balloonadventure.actors.api.EntityIds;
import com.tsioni.balloonadventure.actors.api.SquareWallEntityDefinition;

class SquareWallEntityDefinitionImpl implements SquareWallEntityDefinition
{
    private final int x;
    private final int y;
    private final int layerId;

    SquareWallEntityDefinitionImpl(
        final int x,
        final int y,
        final int layerId)
    {
        this.x = x;
        this.y = y;
        this.layerId = layerId;
    }

    @Override
    public EntityId getEntityId()
    {
        return EntityIds.SQUARE_WALL;
    }

    @Override
    public int getX()
    {
        return x;
    }

    @Override
    public int getY()
    {
        return y;
    }

    @Override
    public int getLayerId()
    {
        return layerId;
    }

    @Override
    public void hostVisitor(final EntityDefinitionVisitor entityDefinitionVisitor)
    {
        entityDefinitionVisitor.visit(this);
    }
}
