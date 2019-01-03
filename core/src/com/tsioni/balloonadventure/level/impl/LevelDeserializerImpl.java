package com.tsioni.balloonadventure.level.impl;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.level.api.LevelDeserializer;
import com.tsioni.balloonadventure.level.api.LevelId;

class LevelDeserializerImpl implements LevelDeserializer
{
    private TmxMapLoader tmxMapLoader;

    @Inject
    public LevelDeserializerImpl(TmxMapLoader tmxMapLoader)
    {
        this.tmxMapLoader = tmxMapLoader;
    }

    @Override
    public TiledMap deserializeLevel(final LevelId levelId)
    {
        final String fileName = "core/assets/levels/" + levelId.toString() + ".tmx";
        return tmxMapLoader.load(fileName);
    }
}
