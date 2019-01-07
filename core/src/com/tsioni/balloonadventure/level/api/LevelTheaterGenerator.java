package com.tsioni.balloonadventure.level.api;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface LevelTheaterGenerator
{
    /**
     * @param batch The batch to use for drawing. This is needed here because the underlying Stage
     *              takes the Batch at construction time.
     *
     * @return A LevelTheater set to the LevelInitialState.
     */
    LevelTheater generateLevelTheater(LevelInitialState levelInitialState, Batch batch);
}
