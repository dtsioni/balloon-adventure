package com.tsioni.balloonadventure.level.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.google.inject.Inject;
import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.TheaterInstantiatorFactory;
import com.tsioni.balloonadventure.level.api.LevelInitialState;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.api.LevelTheaterGenerator;
import com.tsioni.balloonadventure.stage.impl.StageInputProcessorImpl;

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
        final int screenWidth = Gdx.graphics.getWidth();
        final int screenHeight = Gdx.graphics.getHeight();
        final double aspectRatio = (double) screenWidth / screenHeight;
        final int viewportWidth = 300;
        // viewport aspect ratio should be the same as the screen aspect ratio
        final int viewportHeight = (int) (viewportWidth / aspectRatio);

        final OrthographicCamera orthographicCamera = new OrthographicCamera(screenWidth, screenHeight);
        final FitViewport fitViewport = new FitViewport(viewportWidth, viewportHeight, orthographicCamera);
        final Stage stage = new Stage(fitViewport);

        final InputProcessor inputProcessor = new StageInputProcessorImpl(stage);
        Gdx.input.setInputProcessor(inputProcessor);

        final World world = new World(new Vector2(0, -100), false);

        final EntityDefinitionVisitor theaterInstantiator =
            theaterInstantiatorFactory.createTheaterInstantiator(world, stage);

        for (final EntityDefinition entityDefinition : levelInitialState.getEntityDefinitions())
        {
            entityDefinition.hostVisitor(theaterInstantiator);
        }

        return new LevelTheaterImpl(stage, world);
    }
}
