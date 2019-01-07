package com.tsioni.balloonadventure;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Something that can be drawn.
 */
public interface Drawable
{
    /**
     * Draw this thing to the given batch.
     *
     * @param batch The batch to draw to.
     */
    void draw(Batch batch);
}
