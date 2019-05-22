 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.image.*;



public class Player extends GameObject {
    
    private BufferedImage img;
    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
    public void tick() {
        if(x+velX > 0 && x+33+velX < 750){
            x += velX;
        }
        if(y+velY > 0 && y-12+velY < (488)){
            y += velY;
        }
        
        collision();
    }
    
    
    private void collision() {
        for(int i =0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            //collision code
            if(tempObject.getID() == ID.Enemy) { //temp object is enemy
                if(getBounds().intersects(tempObject.getBounds())) { //if the player rectangle is touching the enemy rectangle, health --
                    HUD.health -= 1;
                }
            }
            if(tempObject.getID() == ID.Power){
              if(getBounds().intersects(tempObject.getBounds())) { //if the player rectangle is touching the enemy rectangle, health --
                    HUD.health += 10;
                    handler.removeObject(tempObject);
                }
            }
        }
    }

    
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawImage(img, x, y, 32, 32, null);
        g.fillRect(x, y, 32, 32);
       
    }

}
