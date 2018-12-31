package com.tsioni.balloonadventure.level.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tsioni.balloonadventure.Drawable;
import com.tsioni.balloonadventure.Steppable;
import com.tsioni.balloonadventure.level.api.LevelTheater;

public class LevelTheaterImpl implements LevelTheater
{
    private static final float WORLD_TIME_STEP = 1/60f;
    private static final int WORLD_VELOCITY_ITERATIONS = 6;
    private static final int WORLD_POSITION_ITERATIONS = 2;

    private final Stage stage;
    private final World world;

    private Matrix4 debugMatrix;
    private Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();

    LevelTheaterImpl(final Stage stage, final World world)
    {
        this.stage = stage;
        this.world = world;
    }

    @Override
    public Drawable getDrawable()
    {
        return new Drawable()
        {
            @Override
            public void draw()
            {
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                stage.draw();

                debugMatrix = stage.getCamera().combined;
                debugRenderer.render(world, debugMatrix);
            }
        };
    }

    @Override
    public Steppable getSteppable()
    {
        return new Steppable() {
            @Override
            public void step(float delta)
            {
                world.step(WORLD_TIME_STEP, WORLD_VELOCITY_ITERATIONS, WORLD_POSITION_ITERATIONS);
                stage.act(delta);
            }
        };
    }
}
