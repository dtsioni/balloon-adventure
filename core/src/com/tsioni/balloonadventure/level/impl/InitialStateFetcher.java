package com.tsioni.balloonadventure.level.impl;

import com.tsioni.balloonadventure.entity.api.AbstractBaseEntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionLoader;
import com.tsioni.balloonadventure.entity.api.MinorGoalEntityDefinition;
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

        final MinorGoalCounter minorGoalCounter = new MinorGoalCounter();

        for (final EntityDefinition entityDefinition : entityDefinitions)
        {
            entityDefinition.hostVisitor(minorGoalCounter);
        }

        return new LevelInitialState()
        {
            @Override
            public List<EntityDefinition> getEntityDefinitions()
            {
                return entityDefinitions;
            }

            @Override
            public int getNumberOfMinorGoals()
            {
                return minorGoalCounter.numberOfMinorGoals();
            }
        };
    }

    private static class MinorGoalCounter extends AbstractBaseEntityDefinitionVisitor
    {
        int numberOfMinorGoals = 0;

        @Override
        public void visit(final MinorGoalEntityDefinition minorGoalEntityDefinition)
        {
            numberOfMinorGoals++;
        }

        int numberOfMinorGoals()
        {
            return numberOfMinorGoals;
        }
    }
}
