package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.actors.api.EntityDefinition;
import com.tsioni.balloonadventure.actors.api.TiledMapEntityDefinitionsFactory;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionLoader;
import com.tsioni.balloonadventure.level.api.LevelDeserializer;
import com.tsioni.balloonadventure.level.api.LevelId;

import java.util.List;

class EntityDefinitionLoaderImpl implements EntityDefinitionLoader
{
    private final LevelDeserializer levelDeserializer;
    private final TiledMapEntityDefinitionsFactory tiledMapEntityDefinitionsFactory;

    @Inject
    public EntityDefinitionLoaderImpl(final LevelDeserializer levelDeserializer,
                                      final TiledMapEntityDefinitionsFactory tiledMapEntityDefinitionsFactory)
    {
        this.levelDeserializer = levelDeserializer;
        this.tiledMapEntityDefinitionsFactory = tiledMapEntityDefinitionsFactory;
    }

    @Override
    public List<EntityDefinition> loadEntityDefinitions(LevelId levelId)
    {
        TiledMap loadedMap = levelDeserializer.deserializeLevel(levelId);

        final List<EntityDefinition> entityDefinitions = tiledMapEntityDefinitionsFactory.createEntityDefinitions(loadedMap);

        return entityDefinitions;
    }
}
