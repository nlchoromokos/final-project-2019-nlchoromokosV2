import java.awt.*;
import java.util.*;

public class Spawner {
    int height,width;
    Random random = new Random();
    HUD hud = new HUD();
    Handler handler = new Handler();
    
    public Spawner(Handler handler, HUD hud, int Height, int Width) {
        this.handler = handler;
        this.hud = hud;
        height = Height;
        width = Width;
    }
    
    
    public void tick(){
        if(hud.score%500 == 0){
            handler.addObject(new slowEnemy(random.nextInt(width)-1,random.nextInt(height)-1, ID.Enemy));
        }
        if(hud.score%1000 == 0){
            handler.addObject(new BasicEnemy(random.nextInt(width)-1,random.nextInt(height)-1, ID.Enemy));
        }
        if(hud.score%2000 == 0){
            handler.addObject(new fastEnemy(random.nextInt(width)-1,random.nextInt(height)-1, ID.Fast));
        }
        if(hud.score%2500 == 0){
            handler.addObject(new Medpack(random.nextInt(width)-1, random.nextInt(height)-1, ID.Power));
        }
    }
    
    
    
}
