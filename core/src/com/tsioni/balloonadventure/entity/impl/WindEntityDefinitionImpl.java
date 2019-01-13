package com.tsioni.balloonadventure.entity.impl;

import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.WindEntityDefinition;

class WindEntityDefinitionImpl implements WindEntityDefinition
{

    private final int x;
    private final int y;
    private final int layerId;
    private final int direction;

    WindEntityDefinitionImpl(
        final int x,
        final int y,
        final int layerId,
        final int direction)
    {
        this.x = x;
        this.y = y;
        this.layerId = layerId;
        this.direction = direction;
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
    public int getDirection()
    {
        return direction;
    }

    @Override
    public void hostVisitor(EntityDefinitionVisitor entityDefinitionVisitor)
    {
        entityDefinitionVisitor.visit(this);
    }
}
