import java.awt.*;

public class EnemyFast extends GameObject
{
    public EnemyFast(int x, int y, ID id){
       super(x,y,id);
       
       velX= 10;
       velY= 4;
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(x, y, 10, 10);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        //this can be cleaned up with a clamp method
        if (y <= 0 || y >= Game.HEIGHT - 48) {
        	velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 32) {
        	velX *= -1;
        }
    }

    
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 10, 10);
    }
}
