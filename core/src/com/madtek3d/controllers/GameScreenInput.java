package com.madtek3d.controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.madtek3d.gameworld.GameWorld;


/**
 * Created by Antonio on 25/05/2015.
 */
public class GameScreenInput implements InputProcessor {

    private GameWorld world;

    public GameScreenInput(GameWorld world) {
        this.world = world;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT) {
            world.getPlayer().runLeft();
        } else if (keycode == Input.Keys.RIGHT) {
            world.getPlayer().runRight();
        }

        if(keycode == Input.Keys.UP && world.getPlayer().getPosition().y == 108) {
            world.getPlayer().jump();
        }

        if(keycode == Input.Keys.D) {
            world.getPlayer().stop();
            world.getPlayer().defend();
        }

        if(keycode == Input.Keys.A) {
            world.getPlayer().stop();
            world.getPlayer().attack();
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.UP)
            return false;
        world.getPlayer().stop();
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(screenX < 1280/2) {
            world.getPlayer().runLeft();
        } else {
            world.getPlayer().runRight();
        }

        if(screenY > 720 / 2) {
            world.getPlayer().jump();
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(screenY > 720 / 2) {
            return false;
        }
        world.getPlayer().stop();
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
