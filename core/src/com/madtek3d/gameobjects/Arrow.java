package com.madtek3d.gameobjects;

import com.badlogic.gdx.math.Polygon;
import com.madtek3d.gameworld.GameWorld;

/**
 * Created by Antonio on 05/06/2015.
 */
public class Arrow extends DynamicGameObject {

    private float rotation;

    public Arrow(float posX, float posY, float width, float height) {
        super(posX, posY, width, height);
        rotation = 0;
        velocity.x = 700;
        acceleration.y = GameWorld.GRAVITY;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
        velocity.add(acceleration.cpy().scl(delta));

        if(velocity.y < 0) {
            rotation = (float)(Math.atan2(velocity.y, velocity.x) * 180 / Math.PI);
        }

        bounds.setPosition(position.x, position.y);
        bounds.setRotation(rotation);
    }

    public float getRotation() {
        return rotation;
    }
}
