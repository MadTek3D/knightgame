package com.madtek3d.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.madtek3d.gameobjects.Arrow;
import com.madtek3d.gameobjects.Ground;
import com.madtek3d.gameobjects.Player;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameWorld {

    Player player;
    Arrow arrow;
    public Ground ground;

    public static final float GRAVITY = -36f;

    public GameWorld() {
        ground = new Ground(0, 0, 1280/40, 80/40);
        player = new Player(5, 5, 60/40, 118/40);
        arrow = new Arrow(100, 600, 35, 5);
    }

    public void update(float delta) {
        // delta cap
        if(delta > 0.1) {
            delta = 0.1f;
        }

        //if(ground.getHeight() < player.getPosition().y) {
        if(!Intersector.overlapConvexPolygons(ground.getBounds(),player.getBounds())){
            player.getAcceleration().y = GRAVITY;
        }

        player.update(delta);
        arrow.update(delta);

        checkCollisions();
    }

    private void checkCollisions() {

        if (player.getState() == Player.KnightState.FALLING) {
            if (Intersector.overlapConvexPolygons(player.getBounds(), ground.getBounds())) {
                player.getVelocity().y = 0;
                player.getAcceleration().y = 0;
                player.getPosition().y = 2;
            }
        }

        /*if (Intersector.overlapConvexPolygons(player.getBounds(), arrow.getBounds())) {
            arrow.getVelocity().x = 0;
            arrow.getVelocity().y = 0;
            arrow.getAcceleration().y = 0;
            player.stop();
        }*/
    }

    public Player getPlayer() {
        return player;
    }
}
