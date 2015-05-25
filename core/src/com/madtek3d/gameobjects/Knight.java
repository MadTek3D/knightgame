package com.madtek3d.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Antonio on 24/05/2015.
 */
public class Knight {
    int width;
    int height;

    boolean isFacingLeft;

    Vector2 position;

    Vector2 velocity;
    Vector2 acceleration;

    KnightState state;

    public enum KnightState {
        IDLE, RUNNING
    }

    private static final int SPEED = 128;

    public Knight(int posx, int posy) {
        isFacingLeft = true;
        state = KnightState.IDLE;
        position = new Vector2(posx, posy);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
    }

    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    public void runLeft() {
        velocity.x = -SPEED;
        state = KnightState.RUNNING;
        isFacingLeft = true;
    }

    public void stop() {
        velocity.x = 0;
        state = KnightState.IDLE;
    }

    public KnightState getState() {
        return state;
    }

    public Vector2 getPosition() {
        return position;
    }
}
