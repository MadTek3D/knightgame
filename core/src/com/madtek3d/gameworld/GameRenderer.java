package com.madtek3d.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.madtek3d.knightgame.Assets;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameRenderer {
    private GameWorld world;

    private OrthographicCamera camera;
    private SpriteBatch batcher;

    public GameRenderer(GameWorld world) {
        this.world = world;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();
        batcher.draw(Assets.bg, 0, 0, Assets.bg.getWidth(), Assets.bg.getHeight());
        switch (world.getPlayer().getState()){
            case IDLE:
                if(world.getPlayer().isFacingLeft()) {
                    batcher.draw(Assets.playerIdleLeft, world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerIdleLeft.getRegionWidth(), Assets.playerIdleLeft.getRegionHeight());
                } else {
                    batcher.draw(Assets.playerIdleRight, world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerIdleRight.getRegionWidth(), Assets.playerIdleRight.getRegionHeight());
                }
                break;
            case RUNNING:
                if(world.getPlayer().isFacingLeft()){
                    batcher.draw(Assets.playerWalkingLeft.getKeyFrame(runTime), world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerWalkingLeft.getKeyFrame(runTime).getRegionWidth(), Assets.playerWalkingLeft.getKeyFrame(runTime).getRegionHeight());
                } else {
                    batcher.draw(Assets.playerWalkingRight.getKeyFrame(runTime), world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerWalkingRight.getKeyFrame(runTime).getRegionWidth(), Assets.playerWalkingRight.getKeyFrame(runTime).getRegionHeight());
                }
                break;
            case GUARD:
                if(world.getPlayer().isFacingLeft()){
                    batcher.draw(Assets.playerGuardLeft, world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerGuardLeft.getRegionWidth(), Assets.playerGuardLeft.getRegionHeight());
                } else {
                    batcher.draw(Assets.playerGuardRight, world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerGuardRight.getRegionWidth(), Assets.playerGuardRight.getRegionHeight());
                }
                break;
            case ATTACK:
                if(world.getPlayer().isFacingLeft()){
                    batcher.draw(Assets.playerAttackLeft.getKeyFrame(runTime), world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerAttackLeft.getKeyFrame(runTime).getRegionWidth(), Assets.playerAttackLeft.getKeyFrame(runTime).getRegionHeight());
                } else {
                    batcher.draw(Assets.playerAttackRight.getKeyFrame(runTime), world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerAttackRight.getKeyFrame(runTime).getRegionWidth(), Assets.playerAttackRight.getKeyFrame(runTime).getRegionHeight());
                }
                break;
        }
        batcher.end();
    }
}
