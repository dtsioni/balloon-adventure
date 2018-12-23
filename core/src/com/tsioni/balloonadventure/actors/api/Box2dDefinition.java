package com.tsioni.balloonadventure.actors.api;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import java.util.List;

public interface Box2dDefinition
{
    BodyDef getBodyDef();
    List<FixtureDef> getFixtureDefs();
}
