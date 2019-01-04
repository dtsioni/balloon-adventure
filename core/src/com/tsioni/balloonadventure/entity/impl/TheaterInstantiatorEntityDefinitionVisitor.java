package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.entity.api.BalloonEntity;
import com.tsioni.balloonadventure.entity.api.BalloonEntityDefinition;
import com.tsioni.balloonadventure.entity.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.entity.api.SquareWallEntity;
import com.tsioni.balloonadventure.entity.api.SquareWallEntityDefinition;
import com.tsioni.balloonadventure.entity.api.WindEntity;
import com.tsioni.balloonadventure.entity.api.WindEntityDefinition;
import com.tsioni.balloonadventure.entity.contact.api.ContactListenerFactory;
import com.tsioni.balloonadventure.entity.contact.api.ContactListenerMultiplexer;
import com.tsioni.balloonadventure.level.state.api.LevelGameState;

class TheaterInstantiatorEntityDefinitionVisitor implements EntityDefinitionVisitor
{
    private final World world;
    private final Stage stage;
    private final ContactListenerFactory contactListenerFactory;
    private final LevelGameState levelGameState;

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
        @Assisted final LevelGameState levelGameState)
    {
        this.world = world;
        this.stage = stage;
        this.contactListenerFactory = contactListenerFactory;
        this.levelGameState = levelGameState;
    }

    @Override
    public void visit(
        final BalloonEntityDefinition balloonEntityDefinition)
    {
        final BodyDef bodyDef = new BodyDef();
        final FixtureDef fixtureDef = new FixtureDef();
        final CircleShape shape = new CircleShape();
        final boolean isSensor = false;
        final float density = 0f;
        final float friction = 0f;
        final float restitution = 0f;
        final float width = 10;
        final BodyDef.BodyType bodyType = BodyDef.BodyType.DynamicBody;

        bodyDef.type = bodyType;
        bodyDef.position.set(balloonEntityDefinition.getX(), balloonEntityDefinition.getY());
        bodyDef.fixedRotation = true;

        shape.setRadius(width/2f);

        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;
        fixtureDef.isSensor = isSensor;

        final Body body = world.createBody(bodyDef);

        body.createFixture(fixtureDef);

        final BalloonEntity balloonEntity = new BalloonEntityImpl(body);

        body.setUserData(balloonEntity);

        stage.addActor(balloonEntity.getActor().get());
    }

    @Override
    public void visit(
        final SquareWallEntityDefinition squareWallEntityDefinition)
    {
        final BodyDef bodyDef = new BodyDef();
        final FixtureDef fixtureDef = new FixtureDef();
        final PolygonShape shape = new PolygonShape();
        final boolean isSensor = false;
        final float density = 0f;
        final float friction = 0f;
        final float restitution = 0f;
        final float width = 16;
        final BodyDef.BodyType bodyType = BodyDef.BodyType.StaticBody;

        bodyDef.type = bodyType;
        bodyDef.position.set(squareWallEntityDefinition.getX(), squareWallEntityDefinition.getY());
        bodyDef.fixedRotation = true;

        shape.setAsBox(width, width);

        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;
        fixtureDef.isSensor = isSensor;

        final Body body = world.createBody(bodyDef);

        final SquareWallEntity squareWallEntity = new SquareWallEntityImpl();

        body.createFixture(fixtureDef);
        body.setUserData(squareWallEntity);
    }

    @Override
    public void visit(
        final WindEntityDefinition windEntityDefinition)
    {
        final BodyDef bodyDef = new BodyDef();
        final FixtureDef fixtureDef = new FixtureDef();
        final PolygonShape shape = new PolygonShape();
        final boolean isSensor = true;
        final float density = 0f;
        final float friction = 0f;
        final float restitution = 0f;
        final float width = 5;
        final BodyDef.BodyType bodyType = BodyDef.BodyType.KinematicBody;

        bodyDef.type = bodyType;
        bodyDef.position.set(windEntityDefinition.getX(), windEntityDefinition.getY());
        bodyDef.fixedRotation = true;

        shape.setAsBox(width, width);

        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;
        fixtureDef.isSensor = isSensor;

        final Body body = world.createBody(bodyDef);

        body.createFixture(fixtureDef);

        final WindEntity windEntity = new WindEntityImpl();

        body.setUserData(windEntity);
        stage.addActor(windEntity.getActor().get());

        registerNewContactListener(contactListenerFactory.createEntityContactListener(windEntity));
    }

    private void registerNewContactListener(
        final ContactListener newContactListener)
    {
        multiplexedContactListener = new ContactListenerMultiplexer(
            multiplexedContactListener, newContactListener);

        world.setContactListener(multiplexedContactListener);
    }
}
