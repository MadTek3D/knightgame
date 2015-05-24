package com.madtek3d.knightgame;

import com.badlogic.gdx.Game;
import com.madtek3d.screens.GameScreen;

public class KnightGame extends Game {

	@Override
	public void create () {
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
