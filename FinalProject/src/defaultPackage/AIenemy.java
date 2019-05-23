import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIenemy extends GameObject {
	
	@SuppressWarnings("unused")
	private Handler handler;
	@SuppressWarnings("unused")
	private GameObject player;
	
	public AIenemy(int x, int y, ID id, Handler handler){
	    super(x,y,id);
	    this.handler = handler;
	    
	    for(int i = 0; i < handler.object.size(); i++) {
	    	if(handler.object.get(i).getID() == ID.Player) {      //if i is the player then the GameObject is too
	    		player = handler.object.get(i);
	    	}
	    }
	}
	    
	    public Rectangle getBounds() {
	    	return new Rectangle(x, y, 16, 16);
	    }
	    
	    public void tick() {
	        x += velX;
	        y += velY;
	        
	        float diffX = x - player.getX() - 8;
	        float diffY = y - player.getY() - 8;
	        float distance = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()) ); //distance formula
	        
	        velX = (int) ((-1.0/distance) * diffX*3);
	        velY = (int) ((-1.0/distance) * diffY*3);
	        
	        //this can be cleaned up with a clamp method
	        if (y <= 0 || y >= Game.HEIGHT - 48) {
	        	velY *= -1;
	        }
	        if (x <= 0 || x >= Game.WIDTH - 32) {
	        	velX *= -1;
	        }
	    }

	    
	    public void render(Graphics g) {
	        g.setColor(Color.magenta);
	        g.fillOval(x, y, 16, 16);
	    }
}
