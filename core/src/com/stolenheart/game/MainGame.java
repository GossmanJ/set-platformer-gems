package com.stolenheart.game;


import com.stolenheart.Screens.StartUp;
import com.badlogic.gdx.Game;
import java.awt.*;

public class MainGame extends Game {

    public static final String TITLE = "STOLEN HEART created by Ryan and Jake <3", VERSION = "v0.001";

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public double width = screenSize.width;
    public double height = screenSize.height;

    @Override
    public void create() {
       // setScreen(new StartUp(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }
}