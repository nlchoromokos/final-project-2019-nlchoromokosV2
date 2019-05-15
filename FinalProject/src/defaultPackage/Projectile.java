
/**
 * Write a description of class projectile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class Projectile extends GameObject{

    public Projectile(int x, int y, ID id){
       super(x,y,id);
       
       velX=1;
       velY=1;
    }
    
    public void tick() {
        x += velX;
        y += velY;
    }

    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, 16, 16);
    }
}
