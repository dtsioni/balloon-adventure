package com.tsioni.balloonadventure.actors.api;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface EntityFactoryVisitorFactory
{
    /**
     * Create a visitor which creates entities in the given world.
     */
    EntityFactoryVisitor createEntityFactoryVisitor(World world, Stage stage);
}
