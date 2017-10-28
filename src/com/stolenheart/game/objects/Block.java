package com.stolenheart.game.objects;

import com.stolenheart.game.gamestate.GameState;

import java.awt.*;

public class Block extends Rectangle {

    public static final int tileSize = 128;

    public Block(int x, int y) {
        setBounds(x, y, tileSize, tileSize);
    }

    public void tick(){

    }

    public void draw(Graphics g) {
        g.fillRect(x - (int)GameState.xOffset, y - (int)GameState.yOffset, width, height); //the blocks move to compensate for player movement
    }

}
