package com.pineapple.jennifer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

interface Entity {
    void update(float delta);
    void render(SpriteBatch batch);
}
