package com.stolenheart.game.main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTH = 800; //const representing width
    public static final int HEIGHT = 600; //const representing height

    private Thread thread;
    private boolean isRunning = false;

    private int FPS = 60; //gives the fps the program will aim for
    private long targetTime = 1000 / FPS; //calculates the time (in milliseconds) that is used in later calculations

    private GameStateManager gsm; //sets GameStateManager's shorthand to gsm. Adds the game state functionality to the game panel.

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); //the window's size is set to 800x600

        start();
    }

    //runs as the game starts
    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    //runs as the game runs
    public void run() {
        long start, elapsed, wait; //sets three longs used to calculate framerate

        gsm = new GameStateManager();

        while (isRunning) {
            start = System.nanoTime(); //the system's precise time when the tick started

            tick();
            repaint();

            elapsed = System.nanoTime() - start; //calculates the time elapsed since the tick started
            wait = targetTime - elapsed / 1000000;  //calculates the wait length in milliseconds
            if(wait <= 0) {
                wait = 5; //if the program is running too fast, it caps the speed
            }

            try {
                thread.sleep(wait);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tick() {
        gsm.tick(); //calls the gsm's tick function
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //used to paint the graphics

        g.clearRect(0,0,WIDTH,HEIGHT); //clears the previous drawing before each frame. Might not be needed, but it's better safe than sorry.

        gsm.draw(g); //calls the gsm's draw function

    }

    /*
    The lines below all have to do with the users input. It detects when a key is pressed, released, and typed.
     */

    public void keyPressed(KeyEvent e) {
    //used for when a key is pressed
        gsm.keyPressed(e.getKeyCode()); //calls the gsm's press function with the keycode in place of the int
    }

    public void keyReleased(KeyEvent e) {
    //used for when a key is released
        gsm.keyReleased(e.getKeyCode()); //calls the gsm's released function with the keycode in place of the int
    }

    public void keyTyped(KeyEvent e) {
    //used for when a key is typed (might never be used but I'll keep it here -Jake)
    }
}
