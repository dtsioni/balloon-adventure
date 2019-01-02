package com.tsioni.balloonadventure.actors.api;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.util.api.Optional;

public interface Entity extends EntityVisitorHost
{
    /**
     * @return This entities actor on the stage, if it has one.
     */
    Optional<? extends Actor> getActor();

    /**
     * This visitor will handle the beginning of contact with another Entity.
     */
    EntityVisitor getEntityContactBeginVisitor();

    /**
     * This visitor will handle the end of contact with another Entity.
     */
    EntityVisitor getEntityContactEndVisitor();
}
