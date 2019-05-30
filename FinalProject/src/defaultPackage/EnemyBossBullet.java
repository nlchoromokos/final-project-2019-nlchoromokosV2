
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

	private Handler handler;
	Random r = new Random();
	
    public EnemyBossBullet(int x, int y, ID id, Handler handler){
       super(x,y,id);
       
       this.handler = handler;
       
       velX = (r.nextInt(5 - -5) + -5);  //gives a random number between -5 and 5
       velY=5;
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(x, y, 16, 16);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        if (y >= Game.HEIGHT) handler.removeObject(this);
        
        
        //this can be cleaned up with a clamp method
        /*
        if (y <= 0 || y >= Game.HEIGHT - 40) {
        	velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 32) {
        	velX *= -1;
        }*/
    }

    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, 16, 16);
    }
}
