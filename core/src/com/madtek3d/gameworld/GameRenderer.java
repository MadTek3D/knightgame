package com.madtek3d.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameRenderer {
    private GameWorld world;

    private OrthographicCamera camera;
    private SpriteBatch batcher;

    Texture bg;

    public GameRenderer(GameWorld world) {
        this.world = world;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        bg = new Texture(Gdx.files.internal("data/bg.png"));
    }

    public void render(float deltaTime) {
        batcher.begin();
        batcher.draw(bg, 0 ,0);
        batcher.end();
    }
}
