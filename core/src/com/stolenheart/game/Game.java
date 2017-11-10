package com.stolenheart.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.screens.startup;
import com.badlogic.gdx.Game;
import java.awt.*;

public class MainGame extends Game {

	public static final String TITLE = "SET PLATFORMER", VERSION = "v1.0";

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public double width = screenSize.width;
	public double height = screenSize.height;

	@Override
	public void create () {
		setScreen(new StartUp(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		super.dispose();
	}

	@Override
	public void pause(){
		super.pause();
	}

	@Override
	public void resume(){
		super.resume();
	}
}