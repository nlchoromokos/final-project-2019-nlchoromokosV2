
import java.awt.*;

public class HUD {

    public static int health = 100;
    public int score = 0;
    public int wave = 1;
    
    
    public void tick() {
        health = (int) Game.clamp(health, 0, 100);
        score++;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void render(Graphics g) {
        String score2 = "Score: " + score;
        String wave2 = "Wave: " + wave;
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, health * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
        g.drawString(score2, 15,70);
        g.drawString(wave2, 15, 90);
    }
    
}
