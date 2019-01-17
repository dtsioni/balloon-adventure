package com.tsioni.balloonadventure.level.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.entity.api.Entity;
import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.TheaterInstantiatorFactory;
import com.tsioni.balloonadventure.input.api.InputProcessorRegistry;
import com.tsioni.balloonadventure.level.api.LevelInitialState;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.api.LevelTheaterGenerator;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;
import com.tsioni.balloonadventure.level.state.api.LevelGameStateFactory;

import java.util.HashMap;
import java.util.Map;

public class LevelTheaterGeneratorImpl implements LevelTheaterGenerator
{
    private final TheaterInstantiatorFactory theaterInstantiatorFactory;
    private final LevelGameStateFactory levelGameStateFactory;
    private final InputProcessorRegistry inputProcessorRegistry;

    @Inject
    LevelTheaterGeneratorImpl(
        final TheaterInstantiatorFactory theaterInstantiatorFactory,
        final LevelGameStateFactory levelGameStateFactory,
        final InputProcessorRegistry inputProcessorRegistry)
    {
        this.theaterInstantiatorFactory = theaterInstantiatorFactory;
        this.levelGameStateFactory = levelGameStateFactory;
        this.inputProcessorRegistry = inputProcessorRegistry;
    }

    @Override
    public LevelTheater generateLevelTheater(
        final LevelInitialState levelInitialState,
        final Batch batch)
    {
        final int screenWidth = Gdx.graphics.getWidth();
        final int screenHeight = Gdx.graphics.getHeight();
        final double aspectRatio = (double) screenWidth / screenHeight;
        final int viewportWidth = 100;
        // viewport aspect ratio should be the same as the screen aspect ratio
        final int viewportHeight = (int) (viewportWidth / aspectRatio);

        final OrthographicCamera orthographicCamera = new OrthographicCamera(screenWidth, screenHeight);
        final FitViewport fitViewport = new FitViewport(viewportWidth, viewportHeight, orthographicCamera);
        final Stage stage = new Stage(fitViewport, batch);

        inputProcessorRegistry.registerInputProcessor(stage);

        final World world = new World(new Vector2(0, -90), false);

        final LevelGameState levelGameState = levelGameStateFactory.createLevelGameState();

        final Map<EntityDefinition, Entity> entityDefinitionMap =
            new HashMap<EntityDefinition, Entity>();

        final EntityDefinitionVisitor theaterInstantiator =
            theaterInstantiatorFactory.createTheaterInstantiator(
                world, stage, levelGameState, entityDefinitionMap);

        for (final EntityDefinition entityDefinition : levelInitialState.getEntityDefinitions())
        {
            entityDefinition.hostVisitor(theaterInstantiator);
        }

        return new LevelTheaterImpl(stage, world, levelGameState, entityDefinitionMap);
    }
}
