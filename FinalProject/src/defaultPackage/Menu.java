

import java.util.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends MouseAdapter{
    
    public Game game;
    public boolean flag=false;
    
    public Menu(Game my_game)
    {
        game = my_game;
        game.setGameState(1);
    }
    
    public void mousePressed(MouseEvent e) {
        System.out.println("X: "+e.getX()+"\nY: "+e.getY());
        if(e.getX()>100 && e.getX() < 200)
        {
            if(e.getY()>100 && e.getY() < 200)
            {
                game.setGameState(1);
                System.out.println("clicked");
                flag = true;
            }
        }
        
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    public void mouseClicked(MouseEvent e){
        System.out.println("X: "+e.getX()+"\nY: "+e.getY());
        if(e.getX()>100 && e.getX() < 200)
        {
            if(e.getY()>100 && e.getY() < 200)
            {
                game.setGameState(1);
                System.out.println("clicked");
            }
        }
    }
    
    public void tick()
    {
        if(flag)
        {
            game.setGameState(1);
        }
        //System.out.println("tick");
        game.setGameState(1);
    }  
    
    public void render(Graphics g) {
        g.drawRect(100, 100, 100, 100);
    }
}
