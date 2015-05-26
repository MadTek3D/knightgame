package com.madtek3d.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.madtek3d.controllers.GameScreenInput;
import com.madtek3d.gameobjects.Knight;
import com.madtek3d.gameworld.GameRenderer;
import com.madtek3d.gameworld.GameWorld;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    private float runTime;

    public GameScreen() {
        runTime = 0;
    }

    @Override
    public void show() {
        world = new GameWorld();
        renderer = new GameRenderer(world);
        Gdx.input.setInputProcessor(new GameScreenInput(world));
    }

    @Override
    public void render(float delta) {
        runTime += delta;

        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
