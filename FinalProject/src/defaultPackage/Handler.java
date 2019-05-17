 

import java.awt.Graphics;
import java.util.LinkedList;

//this class is going to maintain and update all the objects in the game

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>(); //list of every object in the game
	
	
	//runs through every single object in the game, updates them and renders them
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i); //lets you get the id of the object and set it to the temp
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i); 
			
			tempObject.render(g);
		}
	}
	
	
	
	public void addObject( GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	
}
