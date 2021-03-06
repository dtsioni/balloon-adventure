package com.tsioni.balloonadventure.entity.api;

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

    /**
     * This visitor will handle setting this Entity's state based on it's Entity definition. This
     * visitor should only visit the Entity definition which corresponds to the concrete Entity's
     * type.
     */
    EntityDefinitionVisitor getEntityDefinitionStateSetterVisitor();
}
