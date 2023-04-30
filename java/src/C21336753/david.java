package C21336753;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class david extends PApplet{

  float angle;

  public void settings(){
    size(550, 600);
  }

  public void setup()
    {
        surface.setLocation(957,0);
        rectMode(CENTER);
        stroke (0,0,0);
        strokeWeight(25);
    }

    public void draw()
    {
      background(0,0,0);
      translate(width/2, height/2);
      for(int i=0; i<50000; i++)
      {
        float red = (float)map(sin(radians(angle)), -1, 1, 180, 232);
        float green = (float)map(cos(radians(angle)), -1, 1, 192, 120);
        float blue = (float)map(cos(radians(angle)), -1, 1, 203, 255);
        fill(red, green, blue);
        scale((float) 0.95);
        rotate(radians(angle));
        float side = 600;
        float offset = side / 2;
        ellipse(side, 0, side, side);
      }
      angle+=0.32;
    }
}

