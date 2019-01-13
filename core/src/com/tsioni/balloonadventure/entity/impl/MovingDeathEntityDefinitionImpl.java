package com.tsioni.balloonadventure.entity.impl;

import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.MovingDeathEntityDefinition;

class MovingDeathEntityDefinitionImpl implements MovingDeathEntityDefinition
{

    private final int x;
    private final int y;
    private final int layerId;
    private final int endX;
    private final int endY;
    private final int period;

    MovingDeathEntityDefinitionImpl(
        final int startX,
        final int startY,
        final int layerId,
        final int endX,
        final int endY,
        final int period)
    {
        this.x = startX;
        this.y = startY;
        this.endX = endX;
        this.endY = endY;
        this.layerId = layerId;
        this.period = period;
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
    public int getEndX()
    {
        return endX;
    }

    @Override
    public int getEndY()
    {
        return endY;
    }

    @Override
    public int getPeriod()
    {
        return period;
    }

    @Override
    public void hostVisitor(final EntityDefinitionVisitor entityDefinitionVisitor)
    {
        entityDefinitionVisitor.visit(this);
    }
}
