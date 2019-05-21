
/**
 * Write a description of class HealthUp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public class HealthUp extends GameObject
{
    public HealthUp(int x, int y, ID id){
       super(x,y,id);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
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
        g.setColor(Color.blue);
        g.fillRect(x, y, 10, 10);
    }
}

