package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.tsioni.balloonadventure.actors.api.BalloonEntityDefinition;
import com.tsioni.balloonadventure.actors.api.EntityDefinitionVisitor;
import com.tsioni.balloonadventure.actors.api.EntityIds;
import com.tsioni.balloonadventure.actors.api.SquareWallEntityDefinition;
import com.tsioni.balloonadventure.actors.api.WindEntityDefinition;
import com.tsioni.balloonadventure.actors.contact.api.ContactListenerMultiplexer;

class TheaterInstantiatorEntityDefinitionVisitor implements EntityDefinitionVisitor
{
    private final World world;
    private final Stage stage;

    /**
     * This contact listener will multiplex all the contact listeners from the Entities being added
     * to the world.
     */
    private ContactListener multiplexedContactListener = new ContactListenerMultiplexer();

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
        body.setUserData(EntityIds.BALLOON);

        stage.addActor(new BalloonEntity(body, balloonEntityDefinition.getLayerId())
            .getActor().get());
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
        final float width = 5;
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

        body.createFixture(fixtureDef);
        body.setUserData(EntityIds.SQUARE_WALL);
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
        body.setUserData(EntityIds.WIND);

        final WindEntity windEntity = new WindEntity(body, windEntityDefinition.getLayerId());

        stage.addActor(windEntity.getActor().get());

        registerNewContactListener(new WindEntityContactListener());
    }

    private void registerNewContactListener(
        final ContactListener newContactListener)
    {
        multiplexedContactListener = new ContactListenerMultiplexer(
            multiplexedContactListener, newContactListener);

        world.setContactListener(multiplexedContactListener);
    }
}
