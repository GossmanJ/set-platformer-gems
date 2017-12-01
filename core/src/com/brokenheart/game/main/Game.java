package com.brokenheart.game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.brokenheart.game.screens.splash;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float x;
	float y;
	
	@Override
	public void create () {
		new splash =
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

	}

	@Override
	public void dispose () {

	}
}
