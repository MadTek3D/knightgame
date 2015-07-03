package com.madtek3d.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Antonio on 01/06/2015.
 */
public abstract class DynamicGameObject extends GameObject {

    protected Vector2 velocity;
    protected Vector2 acceleration;

    public DynamicGameObject(float posX, float posY, float width, float height) {
        super(posX, posY, width, height);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,0);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }
}
