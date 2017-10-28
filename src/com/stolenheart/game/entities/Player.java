package com.stolenheart.game.entities;

import com.stolenheart.game.gamestate.GameState;
import com.stolenheart.game.main.Game;
import com.stolenheart.game.main.GamePanel;
import com.stolenheart.game.objects.Block;
import com.stolenheart.game.physics.Collision;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    //true and false for movement
    private boolean left = false, right = false, jump = false, fall = false;
    private boolean topCollision = false;

    //dimensions for the boundary of the player
    private double x, y;
    private int width, height;

    //speed for moving
    private double moveSpeed = 2.75;

    //speed for jumping
    private double jumpSpeed = 5;
    private double currentJumpSpeed = jumpSpeed;

    //speed for falling
    private double maxFallSpeed = 5;
    private double currentFallSpeed = 0.1;

    public Player(int width, int height) {
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        this.width = width;
        this.height = height;
    }

    public void tick(Block[] b) {
        //i is initialized as 0. It will repeat the function for the length of the array (b), and add 1 to i each loop.

        //pushes the doubles into ints for the point calculations for collision
        int iX = (int)x;
        int iY = (int)y;
        int gsmXOffset = (int)GameState.xOffset;
        int gsmYOffset = (int)GameState.yOffset;

        for(int i = 0; i < b.length; i++) {

            //right side collision (Padding is added to each edge so the player can't get stuck)
            if(Collision.playerBlock(new Point(iX + width + gsmXOffset, iY + gsmYOffset + 2), b[i])
                    || Collision.playerBlock(new Point(iX + width + gsmXOffset, iY + height + gsmYOffset - 1), b[i])) {
                //if the player tries to pass by the two points defined above, their movement completely stops
                right = false;
            }

            //left side collision
            if(Collision.playerBlock(new Point(iX + gsmXOffset - 1, iY + gsmYOffset + 2), b[i])
                || Collision.playerBlock(new Point(iX + gsmXOffset - 1, iY + height + gsmYOffset - 1), b[i])) {
                //if the player tries to pass by the two points defined above, their movement completely stops
                left = false;
            }

            //top collision
            if(Collision.playerBlock(new Point(iX + gsmXOffset + 1, iY + gsmYOffset), b[i])
                    || Collision.playerBlock(new Point(iX + width + gsmXOffset - 1, iY + gsmYOffset), b[i])){
                jump = false;
            }

            //bottom collision I have no clue how the first point calculation actually works, but it started working when I put five in and I don't want to break it.
            if(Collision.playerBlock(new Point(iX + width + gsmXOffset - 5, iY + height + gsmYOffset + 4), b[i])
                    || Collision.playerBlock(new Point(iX + width + gsmXOffset - 1, iY + gsmYOffset + 2), b[i])) {
                y = b[i].getY() - height - GameState.yOffset;
                fall = false;
                topCollision = true;
            }

            //if nothing else, the player is falling
            else {
                if(!topCollision && !jump) {
                    fall = true;
                }
            }
        }

        topCollision = false; //resets the fall

        if(right){
            GameState.xOffset += moveSpeed;
        }

        if(left){
            GameState.xOffset -= moveSpeed;
        }

        if(jump){
            GameState.yOffset -= currentJumpSpeed; //player jumps upward
            currentJumpSpeed -= .1; //jump gradually slows to a stop
            if(currentJumpSpeed <=0){
                currentJumpSpeed = jumpSpeed; //at the top of the arc, the jump calculation is reset
                jump = false; //the player is no longer jumping
                fall = true; //the player is now falling
            }
        }

        if(fall){
            GameState.yOffset+= currentFallSpeed;
            if(currentFallSpeed < maxFallSpeed) {
                currentFallSpeed += .1;
            }
        }

        if(!fall) {
            currentFallSpeed = .1; //when the fall is over, the fall speed is reset for next time
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, width, height); //draws a red rectangle in place of the player
    }

    //key inputs for various actions
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) right = true;
        if(k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) left = true;
        if(k == KeyEvent.VK_SPACE || k == KeyEvent.VK_W) jump = true;
    }

    //key releases for various actions
    public void keyReleased(int k) {
        if(k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) right = false;
        if(k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) left = false;
    }

}
