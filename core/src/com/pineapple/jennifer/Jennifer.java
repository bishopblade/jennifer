package com.pineapple.jennifer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Jennifer extends Game {
	private OrthographicCamera camera;
    SpriteBatch batch;
    Player player;

    int width;
    int height;
	
	@Override
	public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

		batch = new SpriteBatch();

        player = new Player();

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render() {
        super.render();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
