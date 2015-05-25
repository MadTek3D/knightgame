package com.madtek3d.controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.madtek3d.gameobjects.Knight;

/**
 * Created by Antonio on 25/05/2015.
 */
public class GameScreenInput implements InputProcessor {

    private Knight knight;

    public GameScreenInput(Knight knight) {
        this.knight = knight;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT)
            knight.runLeft();
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        knight.stop();
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
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
