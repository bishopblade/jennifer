package com.pineapple.galactica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    int x;
    int y;
    private Texture playerTexture;

    static final int MOVEMENT_SPEED = 7;

    Player() {
        playerTexture = new Texture(Gdx.files.internal("img/ship.png"));
        x = (800 - playerTexture.getWidth()) / 2;
        y = 10;
    }

    public void render(SpriteBatch batch) {
        batch.draw(playerTexture, this.x, this.y);
    }
}
