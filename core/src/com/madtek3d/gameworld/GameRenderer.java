package com.madtek3d.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.madtek3d.gameobjects.Knight;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameRenderer {
    private GameWorld world;

    private OrthographicCamera camera;
    private SpriteBatch batcher;

    Texture bg, knightTexture;
    TextureRegion[] pjFrames;
    TextureRegion pjFacingLeft;
    Animation pjwalking;
    Music bgmusic;

    public GameRenderer(GameWorld world) {
        this.world = world;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        bg = new Texture(Gdx.files.internal("data/bg.png"));
        knightTexture =  new Texture(Gdx.files.internal("data/pj.png"));
        pjFrames = new TextureRegion[8];
        for(int i = 8; i > 0; i--) {
            pjFrames[7-(i-1)] = new TextureRegion(knightTexture, 37*(i-1), 0, 37, 39);
        }
        pjwalking = new Animation(0.06f, pjFrames);
        pjwalking.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        pjFacingLeft = new TextureRegion(knightTexture, 297, 0, 37, 39);

        bgmusic = Gdx.audio.newMusic(Gdx.files.internal("data/Master of the Feast.mp3"));
        bgmusic.play();
    }

    public void render(float runTime) {
        batcher.begin();
        batcher.draw(bg, 0, 0);
        //batcher.draw(pjFacingLeft, 1280/2f, 108);
        if(world.getKnight().getState() == Knight.KnightState.RUNNING) {
            batcher.draw(pjwalking.getKeyFrame(runTime), world.getKnight().getPosition().x, world.getKnight().getPosition().y);
        } else if(world.getKnight().getState() == Knight.KnightState.IDLE) {
            batcher.draw(pjFacingLeft, world.getKnight().getPosition().x, world.getKnight().getPosition().y);
        }
        batcher.end();
    }
}
