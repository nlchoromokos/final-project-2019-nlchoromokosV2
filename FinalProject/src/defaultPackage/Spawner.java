import java.util.*;

public class Spawner {
    int height,width;
    Random random = new Random();
    HUD hud = new HUD();
    Handler handler = new Handler();
    int scoreKeep = 0;
    
    public Spawner(Handler handler, HUD hud, int Height, int Width) {
        this.handler = handler;
        this.hud = hud;
        height = Height;
        width = Width;
    }
    
    
    public void tick(){
    	scoreKeep++;
    	
    	if (scoreKeep >= 1000) {
    		scoreKeep = 0;
    		
    		if(hud.score%1000 == 0){
                hud.wave++;
            }
            if(hud.getWave() == 1) {
            	handler.addObject(new EnemySlow(random.nextInt(width), random.nextInt(height), ID.Slow));
            	handler.addObject(new EnemySlow(random.nextInt(width), random.nextInt(height), ID.Slow));
            }
            if(hud.getWave() == 2) {
            	handler.addObject(new EnemyBasic(random.nextInt(width)-5, random.nextInt(height)-5, ID.Enemy));
            	handler.addObject(new EnemyBasic(random.nextInt(width)-5, random.nextInt(height)-5, ID.Enemy));
            	handler.addObject(new EnemyBasic(random.nextInt(width)-5, random.nextInt(height)-5, ID.Enemy));
            	handler.addObject(new EnemyBasic(random.nextInt(width)-5, random.nextInt(height)-5, ID.Enemy));

            }
            if(hud.getWave() == 3) {
            	handler.addObject(new EnemyBasic(random.nextInt(width)-5, random.nextInt(height)-5, ID.Enemy));
            	handler.addObject(new EnemyAI(random.nextInt(width)-5, random.nextInt(height)-5, ID.Smart, handler));
            	handler.addObject(new EnemyBasic(random.nextInt(width)-5, random.nextInt(height)-5, ID.Enemy));
            	handler.addObject(new EnemyAI(random.nextInt(width)-5, random.nextInt(height)-5, ID.Smart, handler));
            	handler.addObject(new SpeedPower(-10, random.nextInt(height)-5, ID.Power2));
            }
            if(hud.getWave() == 4) {
            	handler.addObject(new EnemyFast(random.nextInt(width)-5, random.nextInt(height)-5, ID.Fast));;
            	handler.addObject(new EnemyAI(random.nextInt(width)-5, random.nextInt(height)-5, ID.Smart, handler));
            	handler.addObject(new EnemyFast(random.nextInt(width)-5, random.nextInt(height)-5, ID.Fast));;
            	handler.addObject(new EnemyAI(random.nextInt(width)-5, random.nextInt(height)-5, ID.Smart, handler));
            	handler.addObject(new Medpack(-10, random.nextInt(height)-5, ID.Power));
            }
            if(hud.getWave() == 5) {
            	handler.clearEnemy();
            	handler.addObject(new EnemyBoss(width/2-96, 0, ID.Boss, handler));
            }
    		
    	}
    }
}  

