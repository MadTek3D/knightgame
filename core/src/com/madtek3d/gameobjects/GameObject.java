package com.madtek3d.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Antonio on 29/05/2015.
 */
public class GameObject {
    protected Vector2 position;
    protected Rectangle bounds;

    public GameObject(float posX, float posY, float width, float height) {
        position = new Vector2(posX, posY);
        bounds = new Rectangle(posX - width/2, posY - height/2, width, height);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
