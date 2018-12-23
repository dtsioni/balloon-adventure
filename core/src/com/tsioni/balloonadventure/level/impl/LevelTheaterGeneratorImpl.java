package com.tsioni.balloonadventure.level.impl;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tsioni.balloonadventure.actors.api.*;
import com.tsioni.balloonadventure.level.api.LevelInitialState;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.api.LevelTheaterFactory;
import com.tsioni.balloonadventure.level.api.LevelTheaterGenerator;

public class LevelTheaterGeneratorImpl implements LevelTheaterGenerator
{
    private final TheaterInstantiatorFactory theaterInstantiatorFactory;
    private final LevelTheaterFactory levelTheaterFactory;

    LevelTheaterGeneratorImpl(
        final LevelTheaterFactory levelTheaterFactory,
        final TheaterInstantiatorFactory theaterInstantiatorFactory)
    {
        this.levelTheaterFactory = levelTheaterFactory;
        this.theaterInstantiatorFactory = theaterInstantiatorFactory;
    }

    @Override
    public LevelTheater generateLevelTheater(final LevelInitialState levelInitialState)
    {
        final Stage stage = new Stage();

        final World world = new World(null, false);

        final EntityDefinitionVisitor theaterInstantiator =
            theaterInstantiatorFactory.createTheaterInstantiator(world, stage);

        for (final EntityDefinition entityDefinition : levelInitialState.getEntityDefinitions())
        {
            entityDefinition.hostVisitor(theaterInstantiator);
        }

        return levelTheaterFactory.createLevelTheater(stage, world);
    }
}
