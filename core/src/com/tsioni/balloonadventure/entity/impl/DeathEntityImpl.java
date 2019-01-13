package com.tsioni.balloonadventure.entity.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.entity.api.*;
import com.tsioni.balloonadventure.util.api.Optional;

class DeathEntityImpl implements DeathEntity
{
    protected final Body body;

    DeathEntityImpl(
        final Body body)
    {
        this.body = body;
        texture = new Texture(IMG_PATH);
        textureRegion = new TextureRegion(texture);
    }

    @Override
    public Optional<? extends Actor> getActor()
    {
        return Optional.empty();
    }

    @Override
    public EntityVisitor getEntityContactBeginVisitor()
    {
        return new AbstractBaseEntityVisitor()
        {
            @Override
            public void visit(final BalloonEntity balloonEntity)
            {
                balloonEntity.killBalloon();
            }
        };
    }

    @Override
    public EntityVisitor getEntityContactEndVisitor()
    {
        return new AbstractBaseEntityVisitor(){};
    }

    @Override
    public EntityDefinitionVisitor getEntityDefinitionStateSetterVisitor()
    {
        return new AbstractBaseEntityDefinitionVisitor()
        {
            @Override
            public void visit(final DeathEntityDefinition deathEntityDefinition)
            {
                body.setTransform(new Vector2(
                    deathEntityDefinition.getX(), deathEntityDefinition.getY()), 0);

                body.setLinearVelocity(new Vector2(0, 0));
                body.setAngularVelocity(0);
            }
        };
    }

    @Override
    public void hostVisitor(final EntityVisitor visitor)
    {
        visitor.visit(this);
    }

    private final String IMG_PATH = "core/assets/img/mine.png";
    private final Texture texture;
    protected final TextureRegion textureRegion;
}
