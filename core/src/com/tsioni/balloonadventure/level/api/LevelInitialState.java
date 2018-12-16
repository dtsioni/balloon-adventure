package com.tsioni.balloonadventure.level.api;

import com.tsioni.balloonadventure.actors.api.EntityDefinition;

import java.util.List;

/**
 * The static state that a level theater begins at for a specific level.
 */
public interface LevelInitialState
{
    /**
     * @return The entities present in the initial state of the level.
     */
    List<EntityDefinition> getEntityDefinitions();
}
