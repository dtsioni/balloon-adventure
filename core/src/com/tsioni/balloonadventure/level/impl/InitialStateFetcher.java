package com.tsioni.balloonadventure.level.impl;

import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionLoader;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.level.api.LevelInitialState;

import java.util.List;

class InitialStateFetcher
{
    private EntityDefinitionLoader entityDefinitionLoader;

    InitialStateFetcher(
        final EntityDefinitionLoader entityDefinitionLoader)
    {
        this.entityDefinitionLoader = entityDefinitionLoader;
    }

    public LevelInitialState fetchLevelInitialState(final LevelId levelId)
    {
        final List<EntityDefinition> entityDefinitions =
            entityDefinitionLoader.loadEntityDefinitions(levelId);

        return new LevelInitialState()
        {
            @Override
            public List<EntityDefinition> getEntityDefinitions()
            {
                return entityDefinitions;
            }
        };
    }
}
