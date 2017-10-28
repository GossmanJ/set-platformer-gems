package com.stolenheart.game.gamestate;

import java.awt.*;
import java.util.Stack;

//this class manages all the states in the game, running the one on top of the stack

public class GameStateManager {

    public Stack<GameState> states;

    public GameStateManager() {
        states = new Stack<GameState>(); //creates a 'stack' of the states, which will be executed in the order that they're added. (Like adding a pause state over the gameplay state, thus pausing the game when it's added.)
        states.push(new MenuState(this));
    }

    public void tick() {
        states.peek().tick();
    }

    public void draw(Graphics g) {
        states.peek().draw(g);
    }

    public void keyPressed(int k) {
        states.peek().keyPressed(k);
    }

    public void keyReleased(int k) {
        states.peek().keyReleased(k);
    }
}
