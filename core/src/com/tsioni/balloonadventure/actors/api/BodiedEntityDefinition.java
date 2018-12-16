package com.tsioni.balloonadventure.actors.api;

public interface BodiedEntityDefinition extends EntityDefinition
{
    /**
     * The Box2dDefinition for the bodied entity.
     * @return
     */
    Box2dDefinition getBox2dDefinition();
}
