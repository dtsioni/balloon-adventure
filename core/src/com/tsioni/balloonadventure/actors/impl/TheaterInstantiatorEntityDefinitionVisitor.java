package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.actors.api.BalloonEntityDefinition;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionVisitor;

class TheaterInstantiatorEntityDefinitionVisitor implements EntityDefinitionVisitor
{
    private final World world;
    private final Stage stage;

    @Inject
    TheaterInstantiatorEntityDefinitionVisitor(
        @Assisted final World world,
        @Assisted final Stage stage)
    {
        this.world = world;
        this.stage = stage;
    }

    @Override
    public void visit(
        final BalloonEntityDefinition balloonEntityDefinition)
    {
        final Body body = world.createBody(balloonEntityDefinition.getBox2dDefinition().getBodyDef());

        stage.addActor(new BalloonEntity(body).getActor());
    }
}
