package com.madtek3d.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.madtek3d.knightgame.Assets;

/**
 * Created by Antonio on 24/05/2015.
 */
public class Player extends DynamicGameObject {
    private float stateTime;
    private boolean isFacingLeft;
    KnightState state;

    public enum KnightState {
        IDLE, RUNNING, JUMPING, DEAD, ATTACK, GUARD, FALLING
    }

    public static final int SPEED = 200;

    public Player(float posX, float posY, float width, float height) {
        super(posX, posY, width, height);
        state = KnightState.IDLE;
        isFacingLeft = true;
        stateTime = 0;
    }

    public void update(float delta) {
        stateTime += delta;

        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
        bounds.setPosition(position.x, position.y);

        if(velocity.y != 0) {
            state = KnightState.JUMPING;
        } else {
            if(velocity.x != 0) {
                state = KnightState.RUNNING;
            } else if (velocity.x == 0 && state != KnightState.JUMPING){
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
        velocity.y = 400;
        Gdx.app.log("jumping", "true");
    }

    public void stop() {
        velocity.x = 0;
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

    public float getStateTime() {
        return stateTime;
    }

    public KnightState getState() {
        return state;
    }
}
