 

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
    
    public Handler handler;
    private Random random;
    private HUD hud;
    private Spawner spawn;
    private Menu menu;
    
    public enum STATE 
    {
        Menu,
        Game,
        Death
    }
    public STATE gameState = STATE.Menu;
    
    public Game(){
        handler = new Handler();
        hud = new HUD();
        random = new Random();
        spawn = new Spawner(handler, hud, HEIGHT, WIDTH);
        
        this.addKeyListener(new KeyInput(handler));
        
        new Window(WIDTH, HEIGHT, "Bullet Heck", this, hud);
        
        if(gameState == STATE.Game) 
        {
            handler.addObject(new Player(100, 100, ID.Player, handler, hud));
            handler.addObject(new EnemySlow(random.nextInt(WIDTH)-5, random.nextInt(HEIGHT)-5, ID.Slow));
            handler.addObject(new EnemySlow(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.Slow));
            handler.addObject(new EnemySlow(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.Slow));}
        menu = new Menu(this);
        if(gameState == STATE.Game) 
        {
            handler.addObject(new Player(100, 100, ID.Player, handler, hud));
            handler.addObject(new EnemySlow(random.nextInt(WIDTH)-5, random.nextInt(HEIGHT)-5, ID.Slow));
            handler.addObject(new EnemySlow(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.Slow));
            handler.addObject(new EnemySlow(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.Slow));}
        }

    public void setGameState(int i)
    {
        if(i==0){
            gameState = STATE.Menu;
        }
        else if(i==1){
            gameState = STATE.Game;
        }
        else if(i==2){
            gameState = STATE.Death;
        }
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
        if(gameState == STATE.Game) {
            hud.tick();
            spawn.tick();
            if(hud.getHealth() <=0) {
                gameState=STATE.Death;
            }
        }
        if(gameState == STATE.Menu) {
            menu.tick();
        }
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
        
        
        if(gameState == STATE.Game) {
            hud.render(g);
            handler.render(g);
        }
        if(gameState == STATE.Menu){
            g.setColor(Color.white);
            g.drawString("Start", 130, 150);
            menu.render(g);
        }
        else if(gameState == STATE.Death) 
        {
            g.setColor(Color.white);
            g.drawString("You Died", WIDTH/2, HEIGHT/2);
            g.drawString("Score: "+hud.score, (WIDTH/2), (HEIGHT/2)+20);
        }
        
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
