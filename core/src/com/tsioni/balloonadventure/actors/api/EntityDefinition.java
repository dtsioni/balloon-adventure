package com.tsioni.balloonadventure.actors.api;

/**
 * The EntityDefinition has all of the information needed to create a single instance of an entity
 * in the theater.
 */
public interface EntityDefinition extends EntityDefinitionVisitorHost
{
    /**
     * TODO: Remove this and the EntityIds, since it is not needed.
     * @return This string uniquely identifies a certain entity in the game.
     */
    EntityId getEntityId();

    int getX();

    int getY();

    /**
     * @return The layer of the entity to be created.
     */
    int getLayerId();
}
