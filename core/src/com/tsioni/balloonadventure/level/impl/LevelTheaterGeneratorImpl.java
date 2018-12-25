package com.tsioni.balloonadventure.level.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.actors.api.EntityDefinition;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.actors.api.TheaterInstantiatorFactory;
import com.tsioni.balloonadventure.level.api.LevelInitialState;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.api.LevelTheaterGenerator;

public class LevelTheaterGeneratorImpl implements LevelTheaterGenerator
{
    private final TheaterInstantiatorFactory theaterInstantiatorFactory;

    @Inject
    LevelTheaterGeneratorImpl(
        final TheaterInstantiatorFactory theaterInstantiatorFactory)
    {
        this.theaterInstantiatorFactory = theaterInstantiatorFactory;
    }

    @Override
    public LevelTheater generateLevelTheater(final LevelInitialState levelInitialState)
    {
        final Stage stage = new Stage();

        final World world = new World(new Vector2(0, -10), false);

        final EntityDefinitionVisitor theaterInstantiator =
            theaterInstantiatorFactory.createTheaterInstantiator(world, stage);

        for (final EntityDefinition entityDefinition : levelInitialState.getEntityDefinitions())
        {
            entityDefinition.hostVisitor(theaterInstantiator);
        }

        return new LevelTheaterImpl(stage, world);
    }
}
