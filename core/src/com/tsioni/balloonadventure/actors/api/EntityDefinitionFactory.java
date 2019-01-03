package com.tsioni.balloonadventure.actors.api;

/**
 * Creates entity definitions.
 */
public interface EntityDefinitionFactory
{
    EntityDefinition createBalloonEntityDef(int x, int y, int layerId);
    EntityDefinition createSquareWallEntityDef(int x, int y, int layerId);
    EntityDefinition createWindEntityDef(int x, int y, int layerId);
}
