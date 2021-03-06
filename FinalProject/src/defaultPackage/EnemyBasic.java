
/**
 * Write a description of class Basic Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;

public class EnemyBasic extends GameObject{

    public EnemyBasic(int x, int y, ID id){
       super(x,y,id);
       
       velX=5;
       velY=5;
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(x, y, 16, 16);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        //this can be cleaned up with a clamp method
        if (y <= 0 || y >= Game.HEIGHT - 40) {
        	velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 32) {
        	velX *= -1;
        }
    }

    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, 16, 16);
    }
}
