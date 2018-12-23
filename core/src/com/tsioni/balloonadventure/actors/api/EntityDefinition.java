package com.tsioni.balloonadventure.actors.api;

public interface EntityDefinition extends EntityDefinitionVisitorHost
{
    /**
     * This string uniquely identifies a certain entity in the game.
     */
    EntityId getEntityId();
}
