package com.tsioni.balloonadventure.entity.impl;

import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.SquareWallEntityDefinition;

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
