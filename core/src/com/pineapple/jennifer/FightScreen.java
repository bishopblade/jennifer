package com.pineapple.jennifer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class FightScreen implements Screen {
    final Jennifer game;

    List<Bullet> bullets;

    OrthographicCamera camera;

    float timeSinceLastBullet = 0.5f;

    Texture bulletTexture;

    final int FIRE_RATE = 5;

    // Delay between shots to have a fire rate of FIRE_RATE
    final float CONV_FIRE_RATE = 1f / FIRE_RATE;

    public FightScreen(final Jennifer gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        bullets = new ArrayList<Bullet>();

        bulletTexture = new Texture(Gdx.files.internal("img/bullet.png"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            game.player.position.x -= Player.MOVEMENT_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            game.player.position.x += Player.MOVEMENT_SPEED;
        } if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            game.player.position.y += Player.MOVEMENT_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            game.player.position.y -= Player.MOVEMENT_SPEED;
        }

        timeSinceLastBullet += delta;
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && timeSinceLastBullet >= CONV_FIRE_RATE) {
            int bulletX = (int) game.player.position.x + game.player.playerTexture.getWidth() / 2 -
                    bulletTexture.getWidth() / 2;
            int bulletY = (int) game.player.position.y + game.player.playerTexture.getHeight();
            Bullet bullet = new Bullet(bulletX, bulletY);
            bullets.add(bullet);

            timeSinceLastBullet = 0.0f;
        }

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);

            bullet.update(delta);
            bullet.render((game.batch));

            if (bullet.offScreen) {
                bullets.remove(i);
            }
        }

        game.player.render(game.batch);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
