package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.entity.api.TiledMapEntityDefinitionsFactory;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionLoader;
import com.tsioni.balloonadventure.level.api.LevelDeserializer;
import com.tsioni.balloonadventure.level.api.LevelId;

import java.util.List;

class EntityDefinitionLoaderImpl implements EntityDefinitionLoader
{
    private final LevelDeserializer levelDeserializer;
    private final TiledMapEntityDefinitionsFactory tiledMapEntityDefinitionsFactory;

    @Inject
    public EntityDefinitionLoaderImpl(
        final LevelDeserializer levelDeserializer,
        final TiledMapEntityDefinitionsFactory tiledMapEntityDefinitionsFactory)
    {
        this.levelDeserializer = levelDeserializer;
        this.tiledMapEntityDefinitionsFactory = tiledMapEntityDefinitionsFactory;
    }

    @Override
    public List<EntityDefinition> loadEntityDefinitions(LevelId levelId)
    {
        final TiledMap loadedMap = levelDeserializer.deserializeLevel(levelId);

        final List<EntityDefinition> entityDefinitions = tiledMapEntityDefinitionsFactory.createEntityDefinitions(loadedMap);

        return entityDefinitions;
    }
}
