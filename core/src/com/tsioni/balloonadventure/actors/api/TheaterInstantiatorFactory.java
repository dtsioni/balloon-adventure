package com.tsioni.balloonadventure.actors.api;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface TheaterInstantiatorFactory
{
    /**
     * Create a visitor which creates entities in the given world.
     */
    EntityDefinitionVisitor createTheaterInstantiator(World world, Stage stage);
}
