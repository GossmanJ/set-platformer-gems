package com.brokenheart.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	private Sprite logo;

	float x;
	float y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Texture logoTexture = new Texture("DabSquadStudios.png");
		logo = new Sprite(logoTexture);
		logo.setX(Gdx.graphics.getWidth() / 2 - (logo.getWidth() / 2));
		logo.setY(Gdx.graphics.getHeight() / 2 - (logo.getHeight() / 2));

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(33/255f, 34/255f, 40/255f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{

		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{

		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{

		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{

		}

		batch.begin();
		logo.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		logo.getTexture().dispose();
	}
}
