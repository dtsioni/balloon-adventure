package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.entity.api.*;
import com.tsioni.balloonadventure.entity.body.api.BodyFactory;
import com.tsioni.balloonadventure.entity.contact.api.ContactListenerFactory;
import com.tsioni.balloonadventure.entity.contact.api.ContactListenerMultiplexer;
import com.tsioni.balloonadventure.entity.path.api.PathFactory;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

import java.util.Map;

class TheaterInstantiatorEntityDefinitionVisitor implements EntityDefinitionVisitor
{
    private final World world;
    private final Stage stage;
    private final ContactListenerFactory contactListenerFactory;
    private final LevelGameState levelGameState;
    private final BodyFactory bodyFactory;
    private final PathFactory pathFactory;
    private final Map<EntityDefinition, Entity> entityDefinitionMap;

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
        final BodyFactory bodyFactory,
        @Assisted final Map<EntityDefinition, Entity> entityDefinitionMap,
        final PathFactory pathFactory)
    {
        this.world = world;
        this.stage = stage;
        this.contactListenerFactory = contactListenerFactory;
        this.levelGameState = levelGameState;
        this.bodyFactory = bodyFactory;
        this.pathFactory = pathFactory;
        this.entityDefinitionMap = entityDefinitionMap;
    }

    @Override
    public void visit(
        final BalloonEntityDefinition balloonEntityDefinition)
    {
        final Body body = bodyFactory.createCircleShapeBody(
            world,
            false,
            0.3f,
            1f,
            0f,
            4,
            BodyDef.BodyType.DynamicBody);

        final BalloonEntity balloonEntity = new BalloonEntityImpl(body, levelGameState);

        finalizeNewEntity(balloonEntity, balloonEntityDefinition, body);
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
            8,
            BodyDef.BodyType.StaticBody);

        final SquareWallEntity squareWallEntity = new SquareWallEntityImpl(body);

        finalizeNewEntity(squareWallEntity, squareWallEntityDefinition, body);
    }

    @Override
    public void visit(
        final WindEntityDefinition windEntityDefinition)
    {
        final int direction = windEntityDefinition.getDirection();
        final Body body = bodyFactory.createBoxShapeBody(
            world,
            true,
            0f,
            0f,
            0f,
            6,
            BodyDef.BodyType.KinematicBody);

        final WindEntity windEntity = new WindEntityImpl(body, direction);

        finalizeNewEntity(windEntity, windEntityDefinition, body);
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
            4,
            BodyDef.BodyType.KinematicBody);

        final GoalEntity goalEntity = new GoalEntityImpl(body, levelGameState, false);

        finalizeNewEntity(goalEntity, goalEntityDefinition, body);
    }

    @Override
    public void visit(final DeathEntityDefinition deathEntityDefinition)
    {
        final Body body = bodyFactory.createCircleShapeBody(
            world,
            true,
            0f,
            0f,
            0f,
            4,
            BodyDef.BodyType.KinematicBody);

        final DeathEntity deathEntity = new DeathEntityImpl(body);

        finalizeNewEntity(deathEntity, deathEntityDefinition, body);
    }

    @Override
    public void visit(final MovingDeathEntityDefinition movingDeathEntityDefinition)
    {
        final int period = movingDeathEntityDefinition.getPeriod();
        final int endX = movingDeathEntityDefinition.getEndX();
        final int endY = movingDeathEntityDefinition.getEndY();

        final Body body = bodyFactory.createCircleShapeBody(
            world,
            true,
            0f,
            0f,
            0f,
            4,
            BodyDef.BodyType.KinematicBody);

        final MovingDeathEntity movingDeathEntity = new MovingDeathEntityImpl(body, endX, endY, period, pathFactory);

        finalizeNewEntity(movingDeathEntity, movingDeathEntityDefinition, body);
    }

    @Override
    public void visit(final MovingPlatformEntityDefinition movingPlatformEntityDefinition)
    {
        final int period = movingPlatformEntityDefinition.getPeriod();
        final int endX = movingPlatformEntityDefinition.getEndX();
        final int endY = movingPlatformEntityDefinition.getEndY();

        final Body body = bodyFactory.createBoxShapeBody(
            world,
            false,
            0f,
            1f,
            0f,
            8,
            BodyDef.BodyType.KinematicBody);

        final MovingPlatformEntity movingPlatformEntity = new MovingPlatformEntityImpl(body, endX, endY, period, pathFactory);

        finalizeNewEntity(movingPlatformEntity, movingPlatformEntityDefinition, body);
    }

    @Override
    public void visit(final MinorGoalEntityDefinition minorGoalEntityDefinition)
    {
        final Body body = bodyFactory.createCircleShapeBody(
            world,
            true,
            0f,
            0f,
            0f,
            4,
            BodyDef.BodyType.KinematicBody);

        final MinorGoalEntityImpl minorGoalEntity =
            new MinorGoalEntityImpl(body, levelGameState, false);

        finalizeNewEntity(minorGoalEntity, minorGoalEntityDefinition, body);
    }

    /**
     * These are the actions required for all new entities to be properly seated in the world/stage.
     */
    private void finalizeNewEntity(
        final Entity entity,
        final EntityDefinition entityDefinition,
        final Body body)
    {
        entityDefinitionMap.put(entityDefinition, entity);

        entityDefinition.hostVisitor(entity.getEntityDefinitionStateSetterVisitor());

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
