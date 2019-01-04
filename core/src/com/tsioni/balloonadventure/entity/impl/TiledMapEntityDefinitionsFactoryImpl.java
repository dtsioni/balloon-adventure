package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.entity.api.*;

import java.util.ArrayList;
import java.util.List;

class TiledMapEntityDefinitionsFactoryImpl implements TiledMapEntityDefinitionsFactory
{
    private EntityDefinitionFactory entityDefinitionFactory;

    @Inject
    public TiledMapEntityDefinitionsFactoryImpl(final EntityDefinitionFactory entityDefinitionFactory)
    {
        this.entityDefinitionFactory = entityDefinitionFactory;
    }

    @Override
    public List<EntityDefinition> createEntityDefinitions(final TiledMap tiledMap)
    {
        final List<EntityDefinition> entityDefinitions = new ArrayList<EntityDefinition>();

        final MapLayer mapLayer = tiledMap.getLayers().get("interactive");
        final TiledMapTileLayer tiledMapTileLayer = (TiledMapTileLayer) mapLayer;
        /* Our entities have their origin in the middle, so we need to offset their position by half a tiles width. */
        final int tileOffset = (int) tiledMapTileLayer.getTileWidth() / 2;
        for(int cellX = 0; cellX < tiledMapTileLayer.getWidth(); cellX++)
        {
            for(int cellY = 0; cellY < tiledMapTileLayer.getHeight(); cellY++)
            {
                final TiledMapTileLayer.Cell cell = tiledMapTileLayer.getCell(cellX, cellY);
                if(cell == null)
                {
                    continue;
                }

                final int entityX = cellX * (int) tiledMapTileLayer.getTileWidth() + tileOffset;
                final int entityY = cellY * (int) tiledMapTileLayer.getTileHeight() + tileOffset;
                final int entityLayerId = 0;

                EntityId entityId = new EntityId(
                    cell.getTile()
                        .getProperties()
                        .get("entityId")
                        .toString());

                if(EntityIds.BALLOON.equals(entityId))
                {
                    entityDefinitions.add(entityDefinitionFactory.createBalloonEntityDef(entityX, entityY, entityLayerId));
                }

                if(EntityIds.SQUARE_WALL.equals(entityId))
                {
                    entityDefinitions.add(entityDefinitionFactory.createSquareWallEntityDef(entityX, entityY, entityLayerId));
                }

                if(EntityIds.WIND.equals(entityId))
                {
                    entityDefinitions.add(entityDefinitionFactory.createWindEntityDef(entityX, entityY, entityLayerId));
                }
            }
        }

        return entityDefinitions;
    }
}
