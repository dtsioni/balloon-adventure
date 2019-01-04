package com.tsioni.balloonadventure.entity.api;

import com.tsioni.balloonadventure.level.api.LevelId;

import java.util.List;

/**
 * Loads entity definitions for a given level.
 */
public interface EntityDefinitionLoader
{
    List<EntityDefinition> loadEntityDefinitions(LevelId levelId);
}
