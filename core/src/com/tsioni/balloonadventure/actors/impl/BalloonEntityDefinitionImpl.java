package com.tsioni.balloonadventure.actors.impl;

import com.tsioni.balloonadventure.actors.api.BalloonEntityDefinition;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionVisitor;

class BalloonEntityDefinitionImpl implements BalloonEntityDefinition
{
    private final int x;
    private final int y;
    private final int layerId;

    BalloonEntityDefinitionImpl(
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
    public void hostVisitor(final EntityDefinitionVisitor visitor)
    {
        visitor.visit(this);
    }
}
