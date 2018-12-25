package com.tsioni.balloonadventure.level.api;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.tsioni.balloonadventure.Drawable;
import com.tsioni.balloonadventure.Steppable;

/**
 * The interactive level.
 */
public interface LevelTheater
{
    /**
     * @return The drawable for the theater.
     */
    Drawable getDrawable();

    /**
     * @return The steppable for the theater.
     */
    Steppable getSteppable();

    /**
     * @return The viewport used to view the theater.
     */
    Viewport getViewport();
}
