package com.madtek3d.gameobjects;

/**
 * Created by Antonio on 10/06/2015.
 */
public class Ground extends GameObject {

    private float slope;

    public Ground(float posX, float posY, float width, float height) {
        super(posX, posY, width, height);
        bounds.setVertices(new float[]{0, 0, width, 0, width, height, 0, height + 1.5f});
        slope = 1.5f / width;
    }

    public float getSlope() {
        return slope;
    }
}
