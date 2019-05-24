 

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Window extends Canvas{

    private static final long serialVersionUID = 1041310355284726095L;
    
    public Window(int width, int height, String title, Game game, HUD hud) {
        JFrame frame = new JFrame(title); //created a JFrame
        //HUD hud = new HUD();
        //sets the dimensions of the frame 
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        
               
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes it actually close
        
        
        //frame.pack(); //keeps size the same
        frame.setResizable(false); // can't resize the image
        frame.setLocationRelativeTo(null); //keeps the screen center upon opening
        frame.add(game); //adds the game to the frame
        frame.setVisible(true); //lets you actually see the window
        game.start();
        if(hud.health == 0){
            game.stop();
        }
    }
}
