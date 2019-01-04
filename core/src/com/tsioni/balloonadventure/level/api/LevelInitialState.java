package com.tsioni.balloonadventure.level.api;

import com.tsioni.balloonadventure.entity.api.EntityDefinition;

import java.util.List;

/**
 * The state that a level theater begins at for a specific level.
 */
public interface LevelInitialState
{
    /**
     * @return The entity definitions for all the entities in the level.
     */
    List<EntityDefinition> getEntityDefinitions();
}
