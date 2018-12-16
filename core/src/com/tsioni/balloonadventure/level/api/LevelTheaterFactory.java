package com.tsioni.balloonadventure.level.api;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface LevelTheaterFactory
{
    LevelTheater createLevelTheater(Stage stage, World world);
}
