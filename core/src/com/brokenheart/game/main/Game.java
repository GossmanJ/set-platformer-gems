package com.brokenheart.game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.brokenheart.game.screens.splash;
import com.brokenheart.game.world.CustomGameMap;
import com.brokenheart.game.world.GameMap;
import com.brokenheart.game.world.TileType;
import com.brokenheart.game.world.TiledGameMap;

public class Game extends ApplicationAdapter {

	SpriteBatch batch;

	OrthographicCamera cam;

	GameMap gameMap;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		new splash();

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();


 		gameMap = new CustomGameMap();

		cam = new OrthographicCamera();
		cam.setToOrtho(false, w, h);
		cam.update();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(33/255f, 34/255f, 40/255f, 0);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

				cam.update();
				gameMap.update(Gdx.graphics.getDeltaTime());
				gameMap.render(cam,batch);
			}

	@Override
	public void dispose () {
		batch.dispose();
		gameMap.dispose();
	}
}
