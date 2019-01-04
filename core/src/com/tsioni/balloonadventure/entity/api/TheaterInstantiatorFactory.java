package com.tsioni.balloonadventure.entity.api;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

public interface TheaterInstantiatorFactory
{
    /**
     * Create a visitor which creates entities in the given world.
     *
     * @param world The world to use in the new theater.
     * @param stage The stage to use in the new theater.
     * @param levelGameState The game state for the entities to use in the new theater.
     * @return
     */
    EntityDefinitionVisitor createTheaterInstantiator(
        World world,
        Stage stage,
        LevelGameState levelGameState);
}
