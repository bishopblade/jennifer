package com.pineapple.jennifer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

class Enemy implements Entity {
    Vector2 position;

    float dx;
    float dy;

    private Texture enemyTexture;

    Enemy() {
        position = new Vector2();
        enemyTexture = new Texture(Gdx.files.internal("img/enemy.png"));
    }

    public void update(float delta) {

    }

    public void render(SpriteBatch batch) {

    }
}
