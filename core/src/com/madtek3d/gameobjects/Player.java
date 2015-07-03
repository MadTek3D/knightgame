package com.madtek3d.gameobjects;

import com.badlogic.gdx.Gdx;

/**
 * Created by Antonio on 24/05/2015.
 */
public class Player extends DynamicGameObject {
    private float stateTime;
    private boolean isFacingLeft;
    private KnightState state;

    // health points
    private int health;

    public enum KnightState {
        IDLE, WALKING, FALLING, ATTACKING, DEFENDING
    }

    public static final int SPEED = 5;

    public Player(float posX, float posY, float width, float height) {
        super(posX, posY, width, height);
        state = KnightState.IDLE;
        isFacingLeft = true;
        stateTime = 0;
        health = 3;
    }

    public void update(float delta) {
        stateTime += delta;

        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
        bounds.setPosition(position.x, position.y);

        if(velocity.y < 0) {
            state = KnightState.FALLING;
        } else {
            if(velocity.x != 0) {
                state = KnightState.WALKING;
            } else if (velocity.x == 0 && state != KnightState.FALLING){
                state = KnightState.IDLE;
            }
        }
    }

    public void runLeft() {
        velocity.x = -SPEED;
        isFacingLeft = true;
    }

    public void runRight() {
        velocity.x = SPEED;
        isFacingLeft = false;
    }

    public void jump() {
        velocity.y = 9;
        Gdx.app.log("jumping", "true");
    }

    public void stop() {
        velocity.set(0 ,0);
    }

    public void defend() {
        state = KnightState.DEFENDING;
    }

    public void attack() {
        state = KnightState.ATTACKING;
    }

    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    public float getStateTime() {
        return stateTime;
    }

    public KnightState getState() {
        return state;
    }
}
