package com.stolenheart.game.gamestate;

import com.stolenheart.game.gamestate.GameState;
import com.stolenheart.game.gamestate.GameStateManager;
import com.stolenheart.game.main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

    private String[] options = {"Play", "Info", "Quit"};
    private int selected = 0;

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {

    }

    public void tick() {

    }

    public void draw(Graphics g) {

        g.setColor(new Color(180, 200, 250)); //creates a nice color for the background.
        g.fillRect(0,0, GamePanel.WIDTH,GamePanel.HEIGHT);


        for(int i = 0; i < options.length; i++) {
            if(i == selected) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.BLACK);
            }
            /*
            g.drawLine(GamePanel.WIDTH / 2, 0, GamePanel.WIDTH / 2, GamePanel.HEIGHT); //used for centering graphics. Ignore
            */
            g.setFont(new Font("Verdana", Font.PLAIN, 50)); //sets a font to use for the next line
            g.drawString(options[i], GamePanel.WIDTH / 2 - 65, 500 / 2 + i * 70); //draws the three options onto the screen. Subject to change, of course.

        }

    }

    //Pretty soon, we can have this program draw art instead of the array, and display different images for the options selected

    public void keyPressed(int k) {
        if(k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
            selected++; //when S or Down are pressed, it cycles up through the array (which is displayed from top to bottom), and will reset if it goes above the option length
            if(selected >= options.length) {
                selected = 0;
            }
        } else if(k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
            selected--;
            if(selected < 0) {
                selected = options.length - 1; //sets back to the last number of the array if the user's input goes too low
            }
        }

        //enters the option that's selected
        if(k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE) {
            if(selected == 0) {
                gsm.states.push(new Level1State(gsm)); //play
            } else if(selected == 1){
                JOptionPane.showMessageDialog(null,"This will probably have helpful information at some point!", "Help", JOptionPane.INFORMATION_MESSAGE);
                //help
            } else if(selected == 2){
                System.exit(0);
            }
        }

    }

    public void keyReleased(int k) {

    }
}
