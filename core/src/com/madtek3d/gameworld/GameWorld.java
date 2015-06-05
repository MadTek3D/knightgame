package com.madtek3d.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.madtek3d.gameobjects.Arrow;
import com.madtek3d.gameobjects.Player;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameWorld {

    Player player;
    Arrow arrow;
    float groundPos;

    public GameWorld() {
        groundPos = 3;
        player = new Player(1280/2, 108, 60, 118);
        arrow = new Arrow(100, 600, 35, 5);
    }

    public void update(float delta) {
        if(delta > 0.1) {
            delta = 0.1f;
        }

        if(Intersector.overlapConvexPolygons(player.arrowBounds, arrow.arrowBounds)) {
            arrow.getVelocity().x = 0;
            arrow.getVelocity().y = 0;
            arrow.getAcceleration().y = 0;
            player.stop();
            Gdx.app.log("Collision", "true");
        }

        player.update(delta);
        arrow.update(delta);
    }

    public Player getPlayer() {
        return player;
    }
}
