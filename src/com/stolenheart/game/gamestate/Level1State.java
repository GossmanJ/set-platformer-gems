package com.stolenheart.game.gamestate;

import com.stolenheart.game.entities.Player;

import java.awt.*;

public class Level1State extends GameState {

    private Player player;

    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(40,70);
    }

    public void tick() {
        player.tick();
    }

    public void draw(Graphics g) {
        player.draw(g);
    }

    public void keyPressed(int k) {
        player.keyPressed(k);
    }

    public void keyReleased(int k) {
        player.keyReleased(k);
    }
}
