package com.madtek3d.gameworld;

import com.madtek3d.gameobjects.Player;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameWorld {

    Player player;
    float groundPos;

    public GameWorld() {
        groundPos = 3;
        player = new Player(1280/2, 108, 1, 1);
    }

    public void update(float delta) {
        player.update(delta);
    }

    public Player getPlayer() {
        return player;
    }
}
