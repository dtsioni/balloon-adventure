package com.tsioni.balloonadventure.level.impl;

import com.google.inject.Inject;
import com.tsioni.balloonadventure.actors.api.EntityDefinition;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionLoader;
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
        return new LevelInitialState()
        {
            @Override
            public List<EntityDefinition> getEntityDefinitions()
            {
                return entityDefinitionLoader.loadEntityDefinitions(levelId);
            }
        };
    }
}
