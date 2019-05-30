import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class SpeedPower extends GameObject
{
	int velX;
    public SpeedPower(int x, int y, ID id){
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
        g.setColor(Color.green);
        g.fillOval(x,y,25,25);
        
    }
}

