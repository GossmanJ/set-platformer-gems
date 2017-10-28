package com.stolenheart.game.gamestate;

import com.stolenheart.game.entities.Player;
import com.stolenheart.game.objects.Block;

import java.awt.*;

public class Level1State extends GameState {

    private Player player;

    private Block[] b;

    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(32,32);

        b = new Block[3];

        b[0] = new Block(100,100);
        b[1] = new Block(200,200);
        b[2] = new Block(375,400);

    }

    public void tick() {

        for(int i = 0; i < b.length; i++) {
            b[i].tick(); //every block that's registered above is refreshed every tick
        }

        player.tick(b); //player's tick is called with the array of blocks
    }

    public void draw(Graphics g) {
        player.draw(g);

        for (int i = 0; i < b.length; i++) {
            b[i].draw(g);
        }

    }

    public void keyPressed(int k) {
        player.keyPressed(k);
    }

    public void keyReleased(int k) {
        player.keyReleased(k);
    }
}
