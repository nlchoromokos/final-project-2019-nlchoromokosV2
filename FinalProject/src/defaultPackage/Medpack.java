
/**
 * Write a description of class HealthUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public class Medpack extends GameObject
{
    public Medpack(int x, int y, ID id){
       super(x,y,id);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }
    
    public void tick() {
        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 32) {
            velX *= -1;
        }
    }

    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 20, 20);
        g.setColor(Color.white);
        g.fillRect(x+5,y+5,5,5);
    }
}

