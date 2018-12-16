package com.tsioni.balloonadventure.actors.api;

/**
 * A visitor for creating entities based on different entity definitions.
 */
public interface EntityFactoryVisitor
{
    /**
     * @return The entity corresponding to the given balloon entity definition.
     */
    void createEntity(BalloonEntityDefinition balloonEntityDefinition);
}
