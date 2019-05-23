 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;



public class Player extends GameObject {
    Color color;
    Handler handler;
    HUD hud;
    
    public Player(int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id);
        this.handler = handler;
        this.hud = hud;
        color = Color.white;
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
    
    
    private boolean collision() {
        for(int i =0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            //collision code
            if(tempObject.getID() == ID.Enemy || tempObject.getID() == ID.Slow) { //temp object is enemy
                if(getBounds().intersects(tempObject.getBounds())) { //if the player rectangle is touching the enemy rectangle, health --
                    HUD.health -= 1;
                    return true;
                }
            }
            if(tempObject.getID() == ID.Power){
              if(getBounds().intersects(tempObject.getBounds())) { //if the player rectangle is touching the enemy rectangle, health --
                    HUD.health += 10;
                    handler.removeObject(tempObject);
                    return true;
                }
            }
            if(tempObject.getID() == ID.Fast || tempObject.getID() == ID.Smart){
              if(getBounds().intersects(tempObject.getBounds())) { //if the player rectangle is touching the enemy rectangle, health --
                    HUD.health -= 10;
                    handler.removeObject(tempObject);
                    return true;
                }
            }
        }
        return false;
    }

    
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 32, 32);
        color = Color.white;
        /*
        if(collision() == true){
            color = Color.red;
        }
        else
            color = Color.white; 
        */
        }
}
