package com.pineapple.galactica;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GalacticaGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Player player;
	
	@Override
	public void create () {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

		batch = new SpriteBatch();

        player = new Player();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

		batch.begin();

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.x -= Player.MOVEMENT_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.x += Player.MOVEMENT_SPEED;
        } if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.y += Player.MOVEMENT_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.y -= Player.MOVEMENT_SPEED;
        }

		player.render(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
