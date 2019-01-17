package com.tsioni.balloonadventure.screen.api;

/**
 * We haven't replaced this with a ScreenId class yet because this is currently only needed for
 * informing Guice on which implementation of Screen to implement for each method of the
 * ScreenFactory it is creating for us. A String works better for that case, because we use these as
 * @Named annotations.
 */
public class Screens
{
    public static final String LEVEL_THEATER_SCREEN = "LEVEL_THEATER_SCREEN";
    public static final String LEVEL_LOADING_SCREEN = "LEVEL_LOADING_SCREEN";
    public static final String LEVEL_SELECT_SCREEN = "LEVEL_SELECT_SCREEN";
}
