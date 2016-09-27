package com.pineapple.jennifer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player implements Entity {
    Vector2 position;
    Texture playerTexture;

    static final int MOVEMENT_SPEED = 7;

    Player() {
        playerTexture = new Texture(Gdx.files.internal("img/ship.png"));

        position = new Vector2();
        position.x = (800 - playerTexture.getWidth()) / 2;
        position.y = 10;
    }

    public void update(float delta) {

    }

    public void render(SpriteBatch batch) {
        batch.draw(playerTexture, this.position.x, this.position.y);
    }
}
