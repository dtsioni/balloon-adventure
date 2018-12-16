package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.tsioni.balloonadventure.actors.api.BalloonEntityDefinition;
import com.tsioni.balloonadventure.actors.api.EntityFactoryVisitor;

public class EntityFactoryVisitorImpl implements EntityFactoryVisitor
{
    private final World world;
    private final Stage stage;

    EntityFactoryVisitorImpl(
        final World world,
        final Stage stage)
    {
        this.world = world;
        this.stage = stage;
    }

    @Override
    public void createEntity(
        final BalloonEntityDefinition balloonEntityDefinition)
    {
        final Body body = world.createBody(balloonEntityDefinition.getBox2dDefinition().getBodyDef());

        stage.addActor(new BalloonEntity(body).getActor());
    }
}
