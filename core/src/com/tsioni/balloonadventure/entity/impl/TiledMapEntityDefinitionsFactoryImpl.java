package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionFactory;
import com.tsioni.balloonadventure.entity.api.EntityId;
import com.tsioni.balloonadventure.entity.api.EntityIds;
import com.tsioni.balloonadventure.entity.api.TiledMapEntityDefinitionsFactory;

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

        final MapLayer objectLayer = tiledMap.getLayers().get("objects");
        final MapObjects mapObjects = objectLayer.getObjects();

        final MapLayer mapLayer = tiledMap.getLayers().get("tiles");
        final TiledMapTileLayer tiledMapTileLayer = (TiledMapTileLayer) mapLayer;

        final int tileWidth = (int) tiledMapTileLayer.getTileWidth();
        final int layerHeight = tiledMapTileLayer.getHeight();
        /* Our entities have their origin in the middle, so we need to offset their position by half a tiles width. */
        final int tileOffset = tileWidth / 2;

        for(int i = 0; i < mapObjects.getCount(); i++)
        {
            final TiledMapTileMapObject mapObject = (TiledMapTileMapObject) mapObjects.get(i);
            final TiledMapTile objectTile = mapObject.getTile();
            final MapProperties objectProperties = mapObject.getProperties();
            final int entityX = (int) Float.parseFloat(objectProperties.get("x").toString()) + tileOffset;
            final int entityY = (int) Float.parseFloat(objectProperties.get("y").toString()) + tileOffset;
            final int entityLayerId = 0;

            EntityId entityId = new EntityId(objectTile.getProperties().get("entityId").toString());

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

            if(EntityIds.GOAL.equals(entityId))
            {
                entityDefinitions.add(entityDefinitionFactory.createGoalEntityDef(entityX, entityY, entityLayerId));
            }

            if(EntityIds.DEATH.equals(entityId))
            {
                entityDefinitions.add(entityDefinitionFactory.createDeathEntityDef(entityX, entityY, entityLayerId));
            }

            if(EntityIds.MINOR_GOAL.equals(entityId))
            {
                entityDefinitions.add(entityDefinitionFactory.createMinorGoalEntityDef(entityX, entityY, entityLayerId));
            }

            if(EntityIds.MOVING_DEATH.equals(entityId))
            {
                final int endX = Integer.parseInt(objectProperties.get("endCellX").toString()) * tileWidth + tileOffset;
                /**
                 * Tiled has a y-down axis, and we have a y-up axis. Start and end positions are defined in reference
                 * to the Tiled grid, so we need to flip their y-axis.
                  */
                final int endY = (layerHeight - Integer.parseInt(objectProperties.get("endCellY").toString()) - 1) * tileWidth + tileOffset;
                final int period = Integer.parseInt(objectProperties.get("period").toString());

                entityDefinitions.add(entityDefinitionFactory.createMovingDeathEntityDef(
                    entityX,
                    entityY,
                    entityLayerId,
                    endX,
                    endY,
                    period));
            }
        }

        return entityDefinitions;
    }
}
