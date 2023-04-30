package C21336753;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

// creating class
public class david extends PApplet {

  // Angle variable to be used in rotation calculations
  float angle;

  // Set the size of the window to 550 x 600
  public void settings() {
    size(550, 600);
  }

  // Initialising settings and location of window
  public void setup() {
    surface.setLocation(957, 0);
    rectMode(CENTER);
    stroke(0, 0, 0);
    strokeWeight(25);
  }

  // Draw the rotating ellipses
  public void draw() {
    background(0, 0, 0); // Set the bg color to black
  
    translate(width / 2, height / 2);  // Translate the origin to the center of  window
  
     // Loop for creating 50000 ellipses
    for (int i = 0; i < 50000; i++) {

      // Calculate the red, green, and blue components of the fill color
      float red = (float) map(sin(radians(angle)), -1, 1, 180, 232);
      float green = (float) map(cos(radians(angle)), -1, 1, 192, 120);
      float blue = (float) map(cos(radians(angle)), -1, 1, 203, 255);
      
      fill(red, green, blue); // Setting fill color
     
      scale((float) 0.95);  // Scaling  ellipse by 0.95
     
      rotate(radians(angle)); // Rotating  ellipse by angle
      
      float side = 600;  // Setting side length of the ellipse
      
      float offset = side / 2; // Calculating the offset of the ellipse
     
      ellipse(side, 0, side, side);  // Drawing ellipse
    }
   
    angle += 0.32;  // Increase the angle by 0.32 (for the speed)
  }
}