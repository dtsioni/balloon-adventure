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
    private final EntityFactoryVisitorFactory entityFactoryVisitorFactory;
    private final LevelTheaterFactory levelTheaterFactory;

    LevelTheaterGeneratorImpl(
        final LevelTheaterFactory levelTheaterFactory,
        final EntityFactoryVisitorFactory entityFactoryVisitorFactory)
    {
        this.levelTheaterFactory = levelTheaterFactory;
        this.entityFactoryVisitorFactory = entityFactoryVisitorFactory;
    }

    @Override
    public LevelTheater generateLevelTheater(final LevelInitialState levelInitialState)
    {
        final Stage stage = new Stage();

        final World world = new World(null, false);

        final EntityFactoryVisitor entityFactoryVisitor =
            entityFactoryVisitorFactory.createEntityFactoryVisitor(world, stage);

        for (final EntityDefinition entityDefinition : levelInitialState.getEntityDefinitions())
        {
            entityDefinition.hostFactoryVisitor(entityFactoryVisitor);
        }

        return levelTheaterFactory.createLevelTheater(stage, world);
    }
}
