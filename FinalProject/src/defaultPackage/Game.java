 

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1L;
    
    public static final int WIDTH = 750, HEIGHT = WIDTH / 12 * 9; // 12/9 aspect ratio
    private Thread thread;
    private boolean running = false;
    
    private Handler handler;
    private Random random;
    private HUD hud;
    private Spawner spawn;
    
    public Game(){
        handler = new Handler();
        hud = new HUD();
        random = new Random();
        spawn = new Spawner(handler, hud, HEIGHT, WIDTH);
        
        this.addKeyListener(new KeyInput(handler));
        
        new Window(WIDTH, HEIGHT, "Bullet Heck", this, hud);

        handler.addObject(new Player(100, 100, ID.Player, handler, hud));
        handler.addObject(new Medpack(random.nextInt(WIDTH)-1, random.nextInt(HEIGHT)-1, ID.Power));
        handler.addObject(new slowEnemy(random.nextInt(WIDTH),random.nextInt(HEIGHT), ID.Slow));
    }
    
    
    //-----the heart beat of the game, standard game loop used by everyone-----
    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    }
    
    //updates whatever is in here
    private void tick() {
        handler.tick();
        hud.tick();
        spawn.tick();
    }
    
    //draws onto the screen
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect( 0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        hud.render(g);
        
        g.dispose();
        bs.show();
    }
    
    public static float clamp(float x, float min, float max) {
        if (x >= max)
            return x = max;
        else if(x <= min)
            return x = min;
        else
            return x;   
    }
    
    //-----start and stop-----
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
      new Game(); 
    }
}
