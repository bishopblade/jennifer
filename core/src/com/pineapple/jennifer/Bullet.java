package com.pineapple.jennifer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet implements Entity {
    private Vector2 position;
    private float velocity;
    private Texture bulletTexture;
    boolean offScreen = false;

    Bullet(int x, int y) {
        position = new Vector2();
        position.x = x;
        position.y = y;

        velocity = 10.0f;

        bulletTexture = new Texture(Gdx.files.internal("img/bullet.png"));
    }

    public void update(float delta) {
        position.y += velocity;

        if (position.y > Gdx.graphics.getHeight()) {
            offScreen = true;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(bulletTexture, position.x, position.y);
    }
}
