package com.pineapple.jennifer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class SplashScreen implements Screen {
    final Jennifer game;
    Texture logoTexture;

    float alpha = 0.0f;
    int direction = 1;

    int logoX, logoY;

    OrthographicCamera camera;

    public SplashScreen(final Jennifer gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        logoTexture = new Texture(Gdx.files.internal("img/logo.jpg"));

        logoX = (game.width - logoTexture.getWidth()) / 2;
        logoY = (game.height - logoTexture.getHeight()) / 2;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        alpha += (0.4f * direction * delta);
        if (alpha >= 1.0f) {
            direction = -1;
        } if (alpha <= 0.0f && direction == -1) {
            game.setScreen(new FightScreen(game));
        }

        game.batch.setColor(1.0f, 1.0f, 1.0f, alpha);
        game.batch.draw(logoTexture, logoX, logoY);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
