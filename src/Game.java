import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stolen Heart"); //creates the window and names it "Stolen Heart"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when pressing X, the app will close (as opposed to hiding or something)
        frame.setResizable(false); //the user cannot resize the game window
        frame.setLayout(new BorderLayout());
        frame.add(new GamePanel(), BorderLayout.CENTER); //refers to the GamePanel class function to set the window size
        frame.pack(); //size the frame
        frame.setVisible(true); //show the frame
    }
}
