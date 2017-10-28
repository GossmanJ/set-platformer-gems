package com.stolenheart.game.gamestate;

import com.stolenheart.game.gamestate.GameStateManager;

import java.awt.*;

/*abstract methods are a bit hard for me to explain, but I'll give it a shot
the methods that were created are going to be required by every state that's created in case we need it.
Though they're required, they won't each be used in every state. The methods are just there in case we need them, and they can be executed in different ways.
*/

//this gamestate abstract class will be used as the basis for all other states of the game, like menus or gameplay screens.
public abstract class GameState {

    protected GameStateManager gsm; //protected means it's accessible from different packages
    public static double xOffset, yOffset; //public can be accessed from any class

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;

        this.xOffset = 0; //when the player moves, the map needs to move to compensate for the player moving
        this.yOffset = 0; //same as above

        init();
    }

    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
}
