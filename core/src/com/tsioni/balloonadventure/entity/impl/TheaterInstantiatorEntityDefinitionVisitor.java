package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.entity.api.BalloonEntity;
import com.tsioni.balloonadventure.entity.api.BalloonEntityDefinition;
import com.tsioni.balloonadventure.entity.api.Entity;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.GoalEntity;
import com.tsioni.balloonadventure.entity.api.GoalEntityDefinition;
import com.tsioni.balloonadventure.entity.api.SquareWallEntity;
import com.tsioni.balloonadventure.entity.api.SquareWallEntityDefinition;
import com.tsioni.balloonadventure.entity.api.WindEntity;
import com.tsioni.balloonadventure.entity.api.WindEntityDefinition;
import com.tsioni.balloonadventure.entity.body.api.BodyFactory;
import com.tsioni.balloonadventure.entity.contact.api.ContactListenerFactory;
import com.tsioni.balloonadventure.entity.contact.api.ContactListenerMultiplexer;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

class TheaterInstantiatorEntityDefinitionVisitor implements EntityDefinitionVisitor
{
    private final World world;
    private final Stage stage;
    private final ContactListenerFactory contactListenerFactory;
    private final LevelGameState levelGameState;
    private final BodyFactory bodyFactory;

    /**
     * This contact listener will multiplex all the contact listeners from the Entities being added
     * to the world.
     */
    private ContactListener multiplexedContactListener = new ContactListenerMultiplexer();

    @Inject
    TheaterInstantiatorEntityDefinitionVisitor(
        @Assisted final World world,
        @Assisted final Stage stage,
        final ContactListenerFactory contactListenerFactory,
        @Assisted final LevelGameState levelGameState,
        final BodyFactory bodyFactory)
    {
        this.world = world;
        this.stage = stage;
        this.contactListenerFactory = contactListenerFactory;
        this.levelGameState = levelGameState;
        this.bodyFactory = bodyFactory;
    }

    @Override
    public void visit(
        final BalloonEntityDefinition balloonEntityDefinition)
    {
        final Body body = bodyFactory.createCircleShapeBody(
            world,
            false,
            0f,
            0f,
            0f,
            10,
            BodyDef.BodyType.DynamicBody,
            balloonEntityDefinition.getX(),
            balloonEntityDefinition.getY());

        final BalloonEntity balloonEntity = new BalloonEntityImpl(body);

        finalizeNewEntity(balloonEntity, body);
    }

    @Override
    public void visit(
        final SquareWallEntityDefinition squareWallEntityDefinition)
    {
        final Body body = bodyFactory.createBoxShapeBody(
            world,
            false,
            0f,
            0f,
            0f,
            16,
            BodyDef.BodyType.StaticBody,
            squareWallEntityDefinition.getX(),
            squareWallEntityDefinition.getY());

        final SquareWallEntity squareWallEntity = new SquareWallEntityImpl();

        finalizeNewEntity(squareWallEntity, body);
    }

    @Override
    public void visit(
        final WindEntityDefinition windEntityDefinition)
    {
        final Body body = bodyFactory.createBoxShapeBody(
            world,
            true,
            0f,
            0f,
            0f,
            5,
            BodyDef.BodyType.KinematicBody,
            windEntityDefinition.getX(),
            windEntityDefinition.getY());

        final WindEntity windEntity = new WindEntityImpl();

        finalizeNewEntity(windEntity, body);
    }

    @Override
    public void visit(final GoalEntityDefinition goalEntityDefinition)
    {
        final Body body = bodyFactory.createBoxShapeBody(
            world,
            true,
            0f,
            0f,
            0f,
            5,
            BodyDef.BodyType.KinematicBody,
            goalEntityDefinition.getX(),
            goalEntityDefinition.getY());

        final GoalEntity goalEntity = new GoalEntityImpl(levelGameState);

        finalizeNewEntity(goalEntity, body);
    }

    /**
     * These are the actions required for all new entities to be properly seated in the world/stage.
     */
    private void finalizeNewEntity(
        final Entity entity,
        final Body body)
    {
        body.setUserData(entity);

        if (entity.getActor().isPresent())
        {
            stage.addActor(entity.getActor().get());
        }

        registerNewContactListener(contactListenerFactory.createEntityContactListener(entity));
    }

    private void registerNewContactListener(
        final ContactListener newContactListener)
    {
        multiplexedContactListener = new ContactListenerMultiplexer(
            multiplexedContactListener, newContactListener);

        world.setContactListener(multiplexedContactListener);
    }
}
