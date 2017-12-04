package com.brokenheart.game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.brokenheart.game.screens.splash;
import com.brokenheart.game.world.GameMap;
import com.brokenheart.game.world.TileType;
import com.brokenheart.game.world.TiledGameMap;

import java.util.Vector;

public class Game extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;

	GameMap gameMap;

	float x;
	float y;
	
	@Override
	public void create () {
		new splash();
 		gameMap = new TiledGameMap();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(33/255f, 34/255f, 40/255f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameMap.render(cam);
		if(Gdx.input.isTouched()){
			cam.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
			cam.update();
		}

		if(Gdx.input.justTouched()){
			Vector3 pos = cam.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
			TileType type = gameMap.getTileTypeByLocation(1, pos.x, pos.y);

			if(type != null){
				System.out.println("You clicked on tile with ID" + type.getId() + " " + type.getName() + " " + type.isCollidable() + " " + type.getDamage());

			}
		}
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}
