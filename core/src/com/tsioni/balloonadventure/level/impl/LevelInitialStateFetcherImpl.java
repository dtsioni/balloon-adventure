package com.tsioni.balloonadventure.level.impl;

import com.google.inject.Inject;
import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionLoader;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.level.api.LevelInitialState;
import com.tsioni.balloonadventure.level.api.LevelInitialStateFetcher;

import java.util.List;

class LevelInitialStateFetcherImpl implements LevelInitialStateFetcher
{
    private EntityDefinitionLoader entityDefinitionLoader;

    @Inject
    LevelInitialStateFetcherImpl(
        final EntityDefinitionLoader entityDefinitionLoader)
    {
        this.entityDefinitionLoader = entityDefinitionLoader;
    }

    @Override
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
