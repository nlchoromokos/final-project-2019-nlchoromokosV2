

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
}
	

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				//key events for player 1
				Player obj = (Player) (tempObject);
				if(obj.speed==false) 
				{
					if(key == KeyEvent.VK_W) {tempObject.setVelY(-7);}
					if(key == KeyEvent.VK_S) {tempObject.setVelY(7);}
					if(key == KeyEvent.VK_D) {tempObject.setVelX(7);}
					if(key == KeyEvent.VK_A) {tempObject.setVelX(-7);}
				}
				if(obj.speed==true) 
				{
					if(key == KeyEvent.VK_W) {tempObject.setVelY(-10);}
					if(key == KeyEvent.VK_S) {tempObject.setVelY(10);}
					if(key == KeyEvent.VK_D) {tempObject.setVelX(10);}
					if(key == KeyEvent.VK_A) {tempObject.setVelX(-10);}
					
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) {System.exit(1);} //closes the game with escape
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				//key events for player 1
				if(key == KeyEvent.VK_W) {tempObject.setVelY(0);}
				if(key == KeyEvent.VK_S) {tempObject.setVelY(0);}
				if(key == KeyEvent.VK_D) {tempObject.setVelX(0);}
				if(key == KeyEvent.VK_A) {tempObject.setVelX(0);}
				}
		}
	}
	
}
