package com.tsioni.balloonadventure.entity.api;

/**
 * Creates entity definitions.
 */
public interface EntityDefinitionFactory
{
    EntityDefinition createBalloonEntityDef(int x, int y, int layerId);
    EntityDefinition createSquareWallEntityDef(int x, int y, int layerId);
    EntityDefinition createWindEntityDef(int x, int y, int layerId);
    EntityDefinition createGoalEntityDef(int x, int y, int layerId);
    EntityDefinition createDeathEntityDef(int x, int y, int layerId);
}
