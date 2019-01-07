package com.tsioni.balloonadventure.level.impl;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tsioni.balloonadventure.debug.Debug;
import com.tsioni.balloonadventure.entity.api.Entity;
import com.tsioni.balloonadventure.entity.api.EntityDefinition;
import com.tsioni.balloonadventure.level.api.LevelInitialState;
import com.tsioni.balloonadventure.level.api.LevelTheater;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

import java.util.Map;

public class LevelTheaterImpl implements LevelTheater
{
    private static final float WORLD_TIME_STEP = 1/60f;
    private static final int WORLD_VELOCITY_ITERATIONS = 6;
    private static final int WORLD_POSITION_ITERATIONS = 2;

    private final Stage stage;
    private final World world;
    private final LevelGameState levelGameState;
    private final Map<EntityDefinition, Entity> entityDefinitionMap;

    private Matrix4 debugMatrix;
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();

    LevelTheaterImpl(
        final Stage stage,
        final World world,
        final LevelGameState levelGameState,
        final Map<EntityDefinition, Entity> entityDefinitionMap)
    {
        this.stage = stage;
        this.world = world;
        this.levelGameState = levelGameState;
        this.entityDefinitionMap = entityDefinitionMap;
    }

    @Override
    public LevelGameState getLevelGameState()
    {
        return levelGameState;
    }

    @Override
    public void setLevelState(
        final LevelInitialState levelInitialState)
    {
        /**
         * TODO: Set the level game state to a specific state, if that is ever needed.
         * TODO: Handle the case where the level initial state does not contain all the entities
         * present in the level.
         */
        Debug.out.println("Restarting the level");

        levelGameState.reset();

        for (final EntityDefinition entityDefinition : levelInitialState.getEntityDefinitions())
        {
            final Entity entity = entityDefinitionMap.get(entityDefinition);

            entityDefinition.hostVisitor(entity.getEntityDefinitionStateSetterVisitor());
        }
    }

    @Override
    public void draw(final Batch batch)
    {
        /**
         * This logic is copied from the Stage.draw() method. We want to manage the Batch
         * ourselves, so we'll handle the Stage drawing manually to avoid the duplicate calls to
         * Batch.begin() and Batch.end() that are performed in Stage.draw().
         */
        final Camera camera = stage.getCamera();
        camera.update();

        final Group root = stage.getRoot();

        if (!root.isVisible()) return;

        batch.setProjectionMatrix(camera.combined);
        root.draw(batch, 1);

        debugMatrix = camera.combined;
        debugRenderer.render(world, debugMatrix);
    }

    @Override
    public void step(final float delta)
    {
        world.step(WORLD_TIME_STEP, WORLD_VELOCITY_ITERATIONS, WORLD_POSITION_ITERATIONS);
        stage.act(delta);
    }
}
