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

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); //the window's size is set to 800x600

        start();
    }

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        long start, elapsed, wait;
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

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //used to paint the graphics

    }

    /*
    The lines below all have to do with the users input. It detects when a key is pressed, released, and typed.
     */

    public void keyPressed(KeyEvent arg0) {
    //used for when a key is pressed
    }

    public void keyReleased(KeyEvent arg0) {
    //used for when a key is released
    }

    public void keyTyped(KeyEvent arg0) {
    //used for when a key is typed
    }

}
