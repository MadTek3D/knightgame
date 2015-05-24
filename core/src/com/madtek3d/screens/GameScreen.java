package com.madtek3d.screens;

import com.badlogic.gdx.Screen;
import com.madtek3d.gameworld.GameRenderer;
import com.madtek3d.gameworld.GameWorld;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    private float deltaTime;

    public GameScreen() {
        deltaTime = 0;

        world = new GameWorld();
        renderer = new GameRenderer(world);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        deltaTime += delta;


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
