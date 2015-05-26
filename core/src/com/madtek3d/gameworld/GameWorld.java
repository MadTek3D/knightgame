package com.madtek3d.gameworld;

import com.madtek3d.gameobjects.Knight;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameWorld {

    Knight knight;
    int groundPos;

    public GameWorld() {
        groundPos = 108;
        knight = new Knight(1280/2, groundPos);
    }

    public void update(float delta) {
        knight.update(delta);
    }

    public Knight getKnight() {
        return knight;
    }
}
