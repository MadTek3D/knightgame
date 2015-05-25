package com.madtek3d.gameworld;

import com.madtek3d.gameobjects.Knight;

/**
 * Created by Antonio on 24/05/2015.
 */
public class GameWorld {

    Knight knight;

    public GameWorld(Knight knight) {
        this.knight = knight;
    }

    public void update(float delta) {
        knight.update(delta);
    }

    public Knight getKnight() {
        return knight;
    }
}
