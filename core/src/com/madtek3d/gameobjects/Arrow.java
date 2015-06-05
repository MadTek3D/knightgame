package com.madtek3d.gameobjects;

import com.badlogic.gdx.math.Polygon;

/**
 * Created by Antonio on 05/06/2015.
 */
public class Arrow extends DynamicGameObject {

    private float rotation;
    public Polygon arrowBounds;

    public Arrow(float posX, float posY, float width, float height) {
        super(posX, posY, width, height);
        rotation = 0;
        velocity.x = 700;
        acceleration.y = -981;
        arrowBounds = new Polygon(new float[]{0,0,bounds.width,0,bounds.width,bounds.height,0,bounds.height});
        arrowBounds.setOrigin(bounds.getWidth()/2, bounds.getHeight()/2);
        arrowBounds.setPosition(posX, posY);
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
        velocity.add(acceleration.cpy().scl(delta));

        rotation -= 50*delta;
        if(rotation < -50) {
            rotation = -50;
        }

        bounds.setPosition(position.x, position.y);
        arrowBounds.setPosition(position.x, position.y);
        arrowBounds.rotate(rotation);
    }

    public float getRotation() {
        return rotation;
    }
}
