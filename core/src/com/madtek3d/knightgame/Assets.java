package com.madtek3d.knightgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Antonio on 03/06/2015.
 */
public class Assets {
    // Textures
    public static Texture bg_l01, bg_l02, bg_l03, bg_l04;
    public static Texture playerIdle;
    public static Texture playerGuard;
    public static Texture playerAttack;
    public static Texture playerWalking;
    public static TextureAtlas player;

    public static TextureRegion arrow;
    public static TextureRegion playerIdleRight, playerIdleLeft;
    public static TextureRegion playerGuardRight, playerGuardLeft;
    public static TextureRegion playerWalkingRightFrames[], playerWalkingLeftFrames[];
    public static TextureRegion playerAttackRightFrames[], playerAttackLeftFrames[];

    // Animations
    public static Animation playerAttackRight, playerAttackLeft;
    public static Animation playerWalkingRight, playerWalkingLeft;

    // Music
    public static Music bgMusic;

    // Sounds

    // Constants
    public static final int PLAYER_WALK_NUM_FRAMES = 4;
    public static final int PLAYER_ATTACK_NUM_FRAMES = 3;

    public static void load() {
        bg_l01 = new Texture(Gdx.files.internal("data/textures/bg01_l01.png"));
        bg_l02 = new Texture(Gdx.files.internal("data/textures/bg01_l02.png"));
        bg_l03 = new Texture(Gdx.files.internal("data/textures/bg01_l03.png"));
        bg_l04 = new Texture(Gdx.files.internal("data/textures/bg01_l04.png"));
        playerIdle = new Texture(Gdx.files.internal("data/textures/knightIdle.png"));
        playerGuard = new Texture(Gdx.files.internal("data/textures/knightGuard.png"));
        playerWalking = new Texture(Gdx.files.internal("data/textures/knightWalk.png"));
        playerAttack = new Texture(Gdx.files.internal("data/textures/knightAttack.png"));
        player = new TextureAtlas(Gdx.files.internal("data/textures/player.pack"));

        arrow = new TextureRegion(new Texture(Gdx.files.internal("data/textures/arrow.png")));

        playerIdleRight = new TextureRegion(playerIdle, playerIdle.getWidth(), playerIdle.getHeight());
        playerIdleRight.flip(true, false);
        playerIdleLeft = new TextureRegion(playerIdle, playerIdle.getWidth(), playerIdle.getHeight());

        playerGuardRight = new TextureRegion(playerGuard, playerGuard.getWidth(), playerGuard.getHeight());
        playerGuardRight.flip(true, false);
        playerGuardLeft = new TextureRegion(playerGuard, playerGuard.getWidth(), playerGuard.getHeight());

        playerWalkingLeftFrames = new TextureRegion[PLAYER_WALK_NUM_FRAMES];
        playerWalkingRightFrames = new TextureRegion[PLAYER_WALK_NUM_FRAMES];
        for(int i = 0; i < PLAYER_WALK_NUM_FRAMES; i++) {
            playerWalkingLeftFrames[i] = player.findRegion("playerWalk0" + (i + 1));
            playerWalkingRightFrames[i] = new TextureRegion(playerWalkingLeftFrames[i]);
            playerWalkingRightFrames[i].flip(true, false);
        }

        playerAttackLeftFrames = new TextureRegion[PLAYER_ATTACK_NUM_FRAMES];
        playerAttackRightFrames = new TextureRegion[PLAYER_ATTACK_NUM_FRAMES];
        for(int i = 0; i < PLAYER_ATTACK_NUM_FRAMES; i++) {
            playerAttackLeftFrames[i] = new TextureRegion(playerAttack, i*107, 0, 107, 135);
            playerAttackRightFrames[i] = new TextureRegion(playerAttack, i*107, 0, 107, 135);
            playerAttackRightFrames[i].flip(true, false);
        }

        playerWalkingRight = new Animation(0.2f, playerWalkingRightFrames);
        playerWalkingRight.setPlayMode(Animation.PlayMode.LOOP);
        playerWalkingLeft = new Animation(0.2f, playerWalkingLeftFrames);
        playerWalkingLeft.setPlayMode(Animation.PlayMode.LOOP);
        playerAttackRight = new Animation(0.2f, playerAttackRightFrames);
        playerAttackRight.setPlayMode(Animation.PlayMode.LOOP);
        playerAttackLeft = new Animation(0.2f, playerAttackLeftFrames);
        playerAttackLeft.setPlayMode(Animation.PlayMode.LOOP);

        // Music
        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("data/music/master_of_the_feast.mp3"));
    }

    public static void dispose() {
        bg_l01.dispose();
        bg_l02.dispose();
        bg_l03.dispose();
        bg_l04.dispose();
        player.dispose();
        playerIdle.dispose();
        playerWalking.dispose();
        playerAttack.dispose();
        playerGuard.dispose();
        arrow.getTexture().dispose();

        bgMusic.dispose();
    }
}
