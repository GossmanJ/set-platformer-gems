package com.brokenheart.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.brokenheart.game.main.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = 800;
		config.height = 800;
		config.vSyncEnabled = true;
		config.forceExit = false;
		new LwjglApplication(new Game(), config);
	}
}
