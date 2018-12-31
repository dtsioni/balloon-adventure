package com.tsioni.balloonadventure.actors.api;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.util.api.Optional;

public interface Entity
{
    /**
     * @return This entities actor on the stage, if it has one.
     */
    Optional<? extends Actor> getActor();

    /**
     * @return The body of this entity, if it has one.
     */
    Optional<Body> getBody();

    /**
     * @return The layer of this entity.
     */
    int getLayerId();
}
