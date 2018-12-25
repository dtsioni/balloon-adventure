package com.tsioni.balloonadventure.level.impl;

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
                stage.draw();
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
