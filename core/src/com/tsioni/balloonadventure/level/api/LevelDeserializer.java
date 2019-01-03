package com.tsioni.balloonadventure.level.api;

import com.badlogic.gdx.maps.tiled.TiledMap;

/**
 * Deserializes a level from the disk.
 */

public interface LevelDeserializer
{
    TiledMap deserializeLevel(LevelId levelId);
}
