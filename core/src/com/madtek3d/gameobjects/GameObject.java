package com.madtek3d.gameobjects;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Antonio on 29/05/2015.
 */
public abstract class GameObject {

    protected Vector2 position;
    protected Polygon bounds;

    public GameObject(float posX, float posY, float width, float height) {
        position = new Vector2(posX, posY);
        bounds = new Polygon(new float[]{0, 0, width, 0, width, height, 0, height});
        bounds.setPosition(posX, posY);
        bounds.setOrigin(width / 2, height / 2);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Polygon getBounds() {
        return bounds;
    }
}
