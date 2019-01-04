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
    public EntityDefinition createWindEntityDef(final int x, final int y, final int layerId)
    {
        return new WindEntityDefinitionImpl(x, y, layerId);
    }

    @Override
    public EntityDefinition createGoalEntityDef(final int x, final int y, final int layerId)
    {
        return new GoalEntityDefinitionImpl(x, y, layerId);
    }
}
