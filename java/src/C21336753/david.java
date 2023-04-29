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
      for(int i=0; i<100; i++)
      {
        fill(i*16, 164-i*50,255-i*10);
        scale((float) 0.95);
      
      rotate(radians(angle));
      rect(0, 0, 600, 600);
      }
      angle+=0.1;
    }
}
