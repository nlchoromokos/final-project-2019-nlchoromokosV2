import java.awt.*;
import java.util.*;

public class Spawner {
    int height,width;
    Random random = new Random();
    HUD hud = new HUD();
    Handler handler = new Handler();
    
    public Spawner(Handler handler, HUD hud, int height, int width) {
        this.handler = handler;
        this.hud = hud;
        height = height;
        width = width;
    }
    
    
    public void tick(){
        try{if(hud.score%100 == 0){
            handler.addObject(new BasicEnemy(random.nextInt(width)-1,random.nextInt(height)-1, ID.Enemy));
        }}catch(Exception e) {System.out.println("yikes");}
    }
    
    
    
}
