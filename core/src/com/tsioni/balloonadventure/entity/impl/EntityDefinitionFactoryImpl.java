package com.tsioni.balloonadventure.entity.impl;

import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionFactory;

public class EntityDefinitionFactoryImpl implements EntityDefinitionFactory
{
    @Override
    public EntityDefinition createBalloonEntityDef(final int x, final int y, final int layerId)
    {
        return new BalloonEntityDefinitionImpl(x, y, layerId);
    }

    @Override
    public EntityDefinition createSquareWallEntityDef(final int x, final int y, final int layerId)
    {
        return new SquareWallEntityDefinitionImpl(x, y, layerId);
    }

    @Override
    public EntityDefinition createWindEntityDef(final int x, final int y, final int layerId, final int direction)
    {
        return new WindEntityDefinitionImpl(x, y, layerId, direction);
    }

    @Override
    public EntityDefinition createGoalEntityDef(final int x, final int y, final int layerId)
    {
        return new GoalEntityDefinitionImpl(x, y, layerId);
    }

    @Override
    public EntityDefinition createDeathEntityDef(final int x, final int y, final int layerId)
    {
        return new DeathEntityDefinitionImpl(x, y, layerId);
    }

    @Override
    public EntityDefinition createMinorGoalEntityDef(final int x, final int y, final int layerId)
    {
        return new MinorGoalEntityDefinitionImpl(x, y, layerId);
    }

    @Override
    public EntityDefinition createMovingDeathEntityDef(
        final int startX,
        final int startY,
        final int layerId,
        final int endX,
        final int endY,
        final int period)
    {
        return new MovingDeathEntityDefinitionImpl(startX, startY, layerId, endX, endY, period);
    }
}
