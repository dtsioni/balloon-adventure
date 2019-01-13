package com.tsioni.balloonadventure.entity.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class AbstractBaseActor extends Actor
{
    private final TextureRegion textureRegion;

    public AbstractBaseActor()
    {
        setWidth(getActorWidth());
        setHeight(getActorHeight());
        setOrigin(getWidth() / 2, getHeight() / 2);

        textureRegion = new TextureRegion(new Texture(getImgPath()));
    }

    @Override
    public void draw(Batch batch, float alpha)
    {
        batch.draw(
            textureRegion,
            getX() - getOriginX(),
            getY() - getOriginY(),
            getOriginX(),
            getOriginY(),
            getWidth(),
            getHeight(),
            getScaleX(),
            getScaleY(),
            getRotation());
    }

    @Override
    public float getX()
    {
        return getBody().getPosition().x;
    }

    @Override
    public float getY()
    {
        return getBody().getPosition().y;
    }

    protected abstract String getImgPath();
    protected abstract float getActorWidth();
    protected abstract float getActorHeight();
    protected abstract Body getBody();
}
