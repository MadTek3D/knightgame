package com.madtek3d.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Antonio on 24/05/2015.
 */
public class Player extends DynamicGameObject {
    private boolean isFacingLeft;
    KnightState state;

    public enum KnightState {
        IDLE, RUNNING, JUMPING, DEAD, ATTACK, GUARD
    }

    private static final int SPEED = 200;

    public Player(float posX, float posY, float width, float height) {
        super(posX, posY, width, height);
        state = KnightState.IDLE;
        isFacingLeft = true;
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));

        if(position.y <= 108) {
            velocity.y = 0;
            acceleration.y = 0;
            position.y = 108;
        }
    }

    public void runLeft() {
        velocity.x = -SPEED;
        state = KnightState.RUNNING;
        isFacingLeft = true;
    }

    public void runRight() {
        velocity.x = SPEED;
        state = KnightState.RUNNING;
        isFacingLeft = false;
    }

    public void jump() {
        velocity.y = 400;
        acceleration.y = -981;
    }

    public void stop() {
        velocity.x = 0;
        state = KnightState.IDLE;
    }

    public void defend() {
        state = KnightState.GUARD;
    }

    public void attack() {
        state = KnightState.ATTACK;
    }

    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    public KnightState getState() {
        return state;
    }
}