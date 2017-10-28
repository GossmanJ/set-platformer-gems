package com.stolenheart.game.entities;

import com.stolenheart.game.main.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Rectangle {

    private boolean left = false, right = false;

    public Player(int width, int height) {
        setBounds(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, width, height);
    }

    public void tick() {
        if(right){
            x++;
        }
        if(left){
            x--;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void keyPressed(int k) {
        if(k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) right = true;
        if(k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) left = true;
    }

    public void keyReleased(int k) {
        if(k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) right = false;
        if(k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) left = false;
    }

}
