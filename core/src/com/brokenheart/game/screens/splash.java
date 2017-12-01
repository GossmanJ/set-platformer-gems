package com.brokenheart.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brokenheart.game.main.Game;

public class splash extends Game {

    SpriteBatch batch;
    private Sprite logo;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Texture logoTexture = new Texture("DabSquadStudios.png");
        logo = new Sprite(logoTexture);
        logo.setX(Gdx.graphics.getWidth() / 2 - (logo.getWidth() / 2));
        logo.setY(Gdx.graphics.getHeight() / 2 - (logo.getHeight() / 2));
    }

    @Override
    public void render() {
        batch.begin();
        logo.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        logo.getTexture().dispose();
    }
}
