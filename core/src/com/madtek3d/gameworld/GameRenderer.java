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
    TextureRegion[] pjFramesLeft;
    TextureRegion[] pjFramesRight;
    TextureRegion pjFacingLeft;
    TextureRegion pjFacingRight;
    Animation knightWalkingLeft;
    Animation knightWalkingRight;
    Music bgmusic;

    public GameRenderer(GameWorld world) {
        this.world = world;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        bg = new Texture(Gdx.files.internal("data/bg.png"));
        knightTexture =  new Texture(Gdx.files.internal("data/pj.png"));
        pjFramesLeft = new TextureRegion[8];
        pjFramesRight = new TextureRegion[8];
        for(int i = 8; i > 0; i--) {
            pjFramesLeft[7-(i-1)] = new TextureRegion(knightTexture, 37*(i-1), 0, 37, 39);
        }
        for(int i = 8; i > 0; i--) {
            pjFramesRight[7-(i-1)] = new TextureRegion(knightTexture, 37*(i-1), 0, 37, 39);
            pjFramesRight[7-(i-1)].flip(true, false);
        }
        knightWalkingLeft = new Animation(0.06f, pjFramesLeft);
        knightWalkingLeft.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        knightWalkingRight = new Animation(0.06f, pjFramesRight);
        knightWalkingRight.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        pjFacingLeft = new TextureRegion(knightTexture, 297, 0, 37, 39);
        pjFacingRight = new TextureRegion(knightTexture, 297, 0, 37, 39);
        pjFacingRight.flip(true, false);

        bgmusic = Gdx.audio.newMusic(Gdx.files.internal("data/Master of the Feast.mp3"));
        bgmusic.play();
    }

    public void render(float runTime) {
        batcher.begin();
        batcher.draw(bg, 0, 0);
        //batcher.draw(pjFacingLeft, 1280/2f, 108);
        if(world.getKnight().getState() == Knight.KnightState.RUNNING) {
            if(world.getKnight().isFacingLeft()){
                batcher.draw(knightWalkingLeft.getKeyFrame(runTime), world.getKnight().getPosition().x, world.getKnight().getPosition().y);
            } else {
                batcher.draw(knightWalkingRight.getKeyFrame(runTime), world.getKnight().getPosition().x, world.getKnight().getPosition().y);
            }

        } else if(world.getKnight().getState() == Knight.KnightState.IDLE) {
            if(world.getKnight().isFacingLeft()) {
                batcher.draw(pjFacingLeft, world.getKnight().getPosition().x, world.getKnight().getPosition().y);
            } else {
                batcher.draw(pjFacingRight, world.getKnight().getPosition().x, world.getKnight().getPosition().y);
            }

        }
        batcher.end();
    }
}
