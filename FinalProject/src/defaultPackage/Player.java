 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.image.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;


public class Player extends GameObject {
    private BufferedImage img;
    
    public Player(int x, int y, ID id, String filepath) {
        super(x, y, id);
        try
        {
            img = ImageIO.read(new File(filepath));
        }
        catch(Exception e){System.out.println(e.toString());}
    }

    
    public void tick() {
        if(x+velX > 0 && x+33+velX < 640)
        {
            x += velX;
        }
        if(y+velY > 0 && y+64+velY < (480))
        {
            y += velY;
        }
    }

    
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawImage(img, x, y, 32, 32, null);
        g.fillRect(x, y, 32, 32);
    }

}
