
/**
 * Write a description of class HealthUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public class Medpack extends GameObject
{
	int velX;
    public Medpack(int x, int y, ID id){
       super(x,y,id);
       velX=1;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }
    
    public void tick() {   
        x+=velX;
    }

    
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 20, 20);
        g.setColor(Color.red);
        g.fillRect(x+7, y+2, 6, 16);
        g.fillRect(x+2, y+7, 16, 6);
    }
}
