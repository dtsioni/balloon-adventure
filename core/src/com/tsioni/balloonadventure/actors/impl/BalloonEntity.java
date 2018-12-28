package com.tsioni.balloonadventure.actors.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tsioni.balloonadventure.actors.api.Entity;
import com.tsioni.balloonadventure.util.api.Optional;

public class BalloonEntity implements Entity
{
    private final Body body;
    private final int layerId;

    BalloonEntity(
        final Body body,
        final int layerId)
    {
        this.body = body;
        this.layerId = layerId;
    }

    @Override
    public Actor getActor()
    {
        return new BalloonActor();
    }

    @Override
    public Optional<Body> getBody()
    {
        return Optional.of(body);
    }

    @Override
    public int getLayerId()
    {
        return layerId;
    }

    class BalloonActor extends Actor
    {
        BalloonActor()
        {
            texture = new Texture(IMG_PATH);
            textureRegion = new TextureRegion(texture);
            setWidth(32);
            setHeight(32);
        }

        @Override
        public void draw(Batch batch, float alpha) {
            batch.draw(textureRegion, getX() - getOriginX(), getY() - getOriginY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        }

        public float getX()
        {
            return getBody().get().getPosition().x;
        }

        public float getY()
        {
            return getBody().get().getPosition().y;
        }

        private final String IMG_PATH = "img/balloon.png";
        private final Texture texture;
        private final TextureRegion textureRegion;
    }
}
