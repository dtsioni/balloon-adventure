package com.tsioni.balloonadventure.level.impl;

import com.google.inject.Inject;
import com.tsioni.balloonadventure.actors.api.EntityDefinition;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionDeserializer;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.level.api.LevelInitialState;
import com.tsioni.balloonadventure.level.api.LevelInitialStateFetcher;

import java.util.List;

class LevelInitialStateFetcherImpl implements LevelInitialStateFetcher
{
    private EntityDefinitionDeserializer entityDefinitionDeserializer;

    @Inject
    LevelInitialStateFetcherImpl(
        final EntityDefinitionDeserializer entityDefinitionDeserializer)
    {
        this.entityDefinitionDeserializer = entityDefinitionDeserializer;
    }

    @Override
    public LevelInitialState fetchLevelInitialState(final LevelId levelId)
    {
        /**
         * TODO: Fetch the level on the disk and deserialize it into entity definitions.
         */
        return new LevelInitialState()
        {
            @Override
            public List<EntityDefinition> getEntityDefinitions()
            {
                return entityDefinitionDeserializer.deserializeEntityDefinitions();
            }
        };
    }
}
