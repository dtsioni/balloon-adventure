package com.tsioni.balloonadventure.actors.api;

/**
 * An EntityDefinition has all of the information needed to create a single instance of an Entity
 * in the theater.
 *
 * The fields present here are the fields which are common across all Entities. This interface
 * should be extended for every Entity that exists in the game. Those interfaces can contain any
 * further information which is needed to define that specific Entity.
 */
public interface EntityDefinition extends EntityDefinitionVisitorHost
{
    /**
     * @return The X of the entity being defined.
     */
    int getX();

    /**
     * @return The Y of the entity being defined.
     */
    int getY();

    /**
     * @return The Layer of the entity being defined.
     */
    int getLayerId();
}
