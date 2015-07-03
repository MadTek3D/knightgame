package com.madtek3d.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.madtek3d.knightgame.Assets;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameRenderer {
    private GameWorld world;

    private OrthographicCamera camera, guiCam;

    private Viewport vp;

    private SpriteBatch batcher;
    private ShapeRenderer debugRenderer;
    private BitmapFont textRenderer;

    public final int V_WIDTH = 32;
    public final int V_HEIGHT = 18;

    public GameRenderer(GameWorld world) {
        this.world = world;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, V_WIDTH, V_HEIGHT);

        guiCam = new OrthographicCamera();
        guiCam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batcher = new SpriteBatch();

        debugRenderer = new ShapeRenderer();

        textRenderer = new BitmapFont();
        textRenderer.setColor(1, 1, 1, 1);
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(world.getPlayer().getPosition().x + (V_WIDTH / 2) < (V_HEIGHT * Assets.bg_l03.getWidth() / Assets.bg_l03.getHeight())) {
            camera.position.set(world.getPlayer().getPosition().x, V_HEIGHT / 2, 0);
            camera.update();
        }

        batcher.setProjectionMatrix(camera.combined);

        batcher.begin();

        batcher.draw(Assets.bg_l01, 0, 0, V_HEIGHT * Assets.bg_l01.getWidth() / Assets.bg_l01.getHeight(), V_HEIGHT);
        batcher.draw(Assets.bg_l02, 0, 0, V_HEIGHT * Assets.bg_l02.getWidth() / Assets.bg_l02.getHeight(), V_HEIGHT);
        batcher.draw(Assets.bg_l03, 0, 0, V_HEIGHT * Assets.bg_l03.getWidth() / Assets.bg_l03.getHeight(), V_HEIGHT);

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
            case WALKING:
                if(world.getPlayer().isFacingLeft()){
                    batcher.draw(Assets.playerWalkingLeft.getKeyFrame(runTime), world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerWalkingLeft.getKeyFrame(runTime).getRegionWidth(), Assets.playerWalkingLeft.getKeyFrame(runTime).getRegionHeight());
                } else {
                    batcher.draw(Assets.playerWalkingRight.getKeyFrame(runTime), world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerWalkingRight.getKeyFrame(runTime).getRegionWidth(), Assets.playerWalkingRight.getKeyFrame(runTime).getRegionHeight());
                }
                break;
            case DEFENDING:
                if(world.getPlayer().isFacingLeft()){
                    batcher.draw(Assets.playerGuardLeft, world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerGuardLeft.getRegionWidth(), Assets.playerGuardLeft.getRegionHeight());
                } else {
                    batcher.draw(Assets.playerGuardRight, world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerGuardRight.getRegionWidth(), Assets.playerGuardRight.getRegionHeight());
                }
                break;
            case ATTACKING:
                if(world.getPlayer().isFacingLeft()){
                    batcher.draw(Assets.playerAttackLeft.getKeyFrame(runTime), world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerAttackLeft.getKeyFrame(runTime).getRegionWidth(), Assets.playerAttackLeft.getKeyFrame(runTime).getRegionHeight());
                } else {
                    batcher.draw(Assets.playerAttackRight.getKeyFrame(runTime), world.getPlayer().getPosition().x, world.getPlayer().getPosition().y,
                            Assets.playerAttackRight.getKeyFrame(runTime).getRegionWidth(), Assets.playerAttackRight.getKeyFrame(runTime).getRegionHeight());
                }
                break;
        }
        batcher.draw(new TextureRegion(Assets.arrow), world.arrow.getPosition().x, world.arrow.getPosition().y, Assets.arrow.getRegionWidth() / 2, Assets.arrow.getRegionHeight() / 2,
                Assets.arrow.getRegionWidth(), Assets.arrow.getRegionHeight(), 1, 1, world.arrow.getRotation());

        batcher.draw(Assets.bg_l04, 0, 0, V_HEIGHT * Assets.bg_l04.getWidth() / Assets.bg_l04.getHeight(), V_HEIGHT);

        batcher.end();

        drawDebug();
    }

    private void drawDebug() {

        debugRenderer.setProjectionMatrix(camera.combined);

        debugRenderer.begin(ShapeRenderer.ShapeType.Line);
        debugRenderer.setColor(Color.BLUE);
        // ground
        /*debugRenderer.rect(world.ground.getBounds().getX(), world.ground.getBounds().getY(),
                world.ground.getWidth(), world.ground.getHeight());*/

        debugRenderer.polygon(world.ground.getBounds().getTransformedVertices());
        // player
        /*debugRenderer.rect(world.getPlayer().getBounds().getX(), world.getPlayer().getBounds().getY(),
                world.getPlayer().getBounds().getBoundingRectangle().getWidth(), world.getPlayer().getBounds().getBoundingRectangle().getHeight());*/

        debugRenderer.polygon(world.getPlayer().getBounds().getTransformedVertices());
        // arrow
        /*debugRenderer.rect(world.arrow.getBounds().getX(), world.arrow.getBounds().getY(),
                world.arrow.getBounds().getOriginX(), world.arrow.getBounds().getOriginY(),
                world.arrow.getWidth(), world.arrow.getHeight(),
                1, 1, world.arrow.getRotation());*/

        debugRenderer.polygon(world.arrow.getBounds().getTransformedVertices());
        debugRenderer.end();

        batcher.setProjectionMatrix(guiCam.combined);
        batcher.begin();
        textRenderer.draw(batcher, Gdx.graphics.getFramesPerSecond() + " FPS", 25, 720-25);
        batcher.end();
    }
}
