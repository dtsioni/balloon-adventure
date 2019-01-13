package com.tsioni.balloonadventure.level.impl;

import com.google.inject.Inject;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionLoader;
import com.tsioni.balloonadventure.level.api.Level;
import com.tsioni.balloonadventure.level.api.LevelFetcher;
import com.tsioni.balloonadventure.level.api.LevelId;
import com.tsioni.balloonadventure.level.api.LevelIds;
import com.tsioni.balloonadventure.level.api.LevelInitialState;

import java.util.HashMap;
import java.util.Map;

class LevelFetcherImpl implements LevelFetcher
{
    private final EntityDefinitionLoader entityDefinitionLoader;

    /**
     * TODO: Handle this in a way that doesn't involve making code changes to reorganize our levels.
     */
    private Map<LevelId, LevelId> nextLevels = new HashMap<LevelId, LevelId>();
    {
        nextLevels.put(LevelIds.TEST_1, LevelIds.TEST_2);
        nextLevels.put(LevelIds.TEST_2, LevelIds.TEST_3);
        nextLevels.put(LevelIds.TEST_3, LevelIds.TEST_1);
    }

    @Inject
    LevelFetcherImpl(
        final EntityDefinitionLoader entityDefinitionLoader)
    {
        this.entityDefinitionLoader = entityDefinitionLoader;
    }

    @Override
    public Level fetchLevel(final LevelId levelId)
    {
        final InitialStateFetcher initialStateFetcher = new InitialStateFetcher(
            entityDefinitionLoader);

        final LevelInitialState levelInitialState = initialStateFetcher
            .fetchLevelInitialState(levelId);

        return new Level()
        {
            @Override
            public LevelId getLevelId()
            {
                return levelId;
            }

            @Override
            public LevelId getNextLevel()
            {
                return nextLevels.get(levelId);
            }

            @Override
            public LevelInitialState getLevelInitialState()
            {
                return levelInitialState;
            }
        };
    }
}
