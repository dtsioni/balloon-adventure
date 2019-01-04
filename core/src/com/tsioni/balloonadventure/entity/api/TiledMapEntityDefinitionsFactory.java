package com.tsioni.balloonadventure.entity.api;

import com.badlogic.gdx.maps.tiled.TiledMap;

import java.util.List;
/**
 *  Creates entity definitions from a tiled map.
 */
public interface TiledMapEntityDefinitionsFactory
{
    List<EntityDefinition> createEntityDefinitions(TiledMap tiledMap);
}
