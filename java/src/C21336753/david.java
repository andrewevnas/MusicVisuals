package C21336753;

import ie.tudublin.*;
import processing.core.PApplet;

public class david extends Visual
{
    float angle = 0;
    boolean started = false;

    public void draw(DON c)
    {
        e.background(0); 
        e.translate(e.width / 2, e.height / 2);  
      
        for (int i = 0; i < 1000; i++)
        {
            float red = (float) c.map(c.sin(c.radians(angle)), -1, 1, 180, 232);
            float green = (float) c.map(c.cos(c.radians(angle)), -1, 1, 192, 120);
            float blue = (float) c.map(c.cos(c.radians(angle)), -1, 1, 203, 255);
            
            c.fill(red, green, blue);
            c.scale((float) 0.95);
            c.rotate(c.radians(angle));
            float side = 600;
            float offset = side / 2;
            c.ellipse(side, 0, side, side);
        }
        angle += 0.17;
    }
}
