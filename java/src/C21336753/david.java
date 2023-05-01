package C21336753;

import ie.tudublin.*;
import processing.core.PApplet;

public class david extends Visual
{
    float angle = 0;

    public void draw(DON e)
    {
        e.background(0); 
        e.translate(e.width / 2, e.height / 2);  
      
<<<<<<< HEAD
        for (int i = 0; i < 100; i++)
=======
        for (int i = 0; i < 1000; i++)
>>>>>>> c2e71f737b083988be2d4762431791cf78732df7
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
}
