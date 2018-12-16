package com.tsioni.balloonadventure.actors.api;

import com.badlogic.gdx.scenes.scene2d.Actor;

public interface ActorFactory
{
    /**
     * @return The actor defined by the actor definition.
     */
    Actor createActor(ActorDefinition actorDefinition);
}
