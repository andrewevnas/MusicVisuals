package C21336753;

import ie.tudublin.*;
import processing.core.PApplet;

public class david extends Visual
{
    float angle = 0;
    boolean started = false;

    public void draw(DON e)
    {
        if (!started)
            return;

        e.background(0, 0, 0); 
        e.translate(e.width / 2, e.height / 2);  
      
        for (int i = 0; i < 1000; i++)
        {
            float red = (float) e.map(e.sin(e.radians(angle)), -1, 1, 180, 232);
            float green = (float) e.map(e.cos(e.radians(angle)), -1, 1, 192, 120);
            float blue = (float) e.map(e.cos(e.radians(angle)), -1, 1, 203, 255);
            
            e.fill(red, green, blue);
            e.scale((float) 0.95);
            e.rotate(e.radians(angle));
            float side = 600;
            float offset = side / 2;
            e.ellipse(side, 0, side, side);
        }
        angle += 0.17;
    }

    public void keyPressed()
    {
        if (key == ' ')
            started = true;
    }
}
