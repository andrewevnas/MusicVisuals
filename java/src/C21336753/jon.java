package C21336753;

import ie.tudublin.Visual;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class jon extends Visual {
  float radius; // radius of the main circle
  float angle1 = 0; // initial angle of rotation for circle 1 (clockwise)
  float angle2 = PI; // initial angle of rotation for circle 2 (counter-clockwise)
  float angle3 = HALF_PI; // initial angle of rotation for circle 3 (counter-clockwise)
  float angle4 = 0;
  float rotationRadius1 = 75; // radius of circle 1
  float rotationRadius2 = 150; // radius of circle 2
  float rotationRadius3 = 225; // radius of circle 3
  float rotationRadius4 = 325; // radius of circle 4
  float centerX; // X coordinate of center of screen
  float centerY; // Y coordinate of center of screen

  public void draw(DON e) 
  {


    

    // set the center coordinates and radius of the main circle
    centerX = width / 2;
    centerY = height / 2;
    radius = 100; // for example, set the radius to 100 pixels
    e.background(255); // set the background color to white


    // set the fill color of the outer circle to red
    e.fill(255, 0, 0);

    // draw the outer circle in the center of the screen
    float outerRadius = 50; // set the radius of the outer circle to 50 pixels
    e.ellipse(centerX, centerY, outerRadius * 2, outerRadius * 2);

    // calculate the position of circle 1 using trigonometry
    float x1 = cos(angle1) * (radius + rotationRadius1);
    float y1 = sin(angle1) * (radius + rotationRadius1);

    // set the fill color of circle 1 to blue
    e.fill(0, 0, 255);

    // draw circle 1
    float r1 = 20; // for example, set the radius of circle 1 to 20 pixels
    e.ellipse(centerX + x1, centerY + y1, r1 * 2, r1 * 2);

    // increment the angle of circle 1 to make it rotate clockwise
    angle1 += 0.05; // for example, rotate at a rate of 0.05 radians per frame

    // calculate the position of circle 2 using trigonometry
    float x2 = cos(angle2) * (radius + rotationRadius2);
    float y2 = sin(angle2) * (radius + rotationRadius2);

    // set the fill color of circle 2 to red
    e.fill(255, 0, 0);

    // draw circle 2
    float r2 = 30; // for example, set the radius of circle 2 to 30 pixels
    e.ellipse(centerX + x2, centerY + y2, r2 * 2, r2 * 2);

    // increment the angle of circle 2 to make it rotate counter-clockwise
    angle2 -= 0.03; // for example, rotate at a rate of 0.03 radians
    // per frame

    // calculate the position of circle 3 using trigonometry
    float x3 = cos(angle3) * (radius + rotationRadius3);
    float y3 = sin(angle3) * (radius + rotationRadius3);
    // set the fill color of circle 3 to green
    e.fill(0, 255, 0);

    // draw circle 3
    float r3 = 40; // for example, set the radius of circle 3 to 40 pixels
    e.ellipse(centerX + x3, centerY + y3, r3 * 2, r3 * 2);

    // increment the angle of circle 3 to make it rotate counter-clockwise
    angle3 += 0.02; // for example, rotate at a rate of 0.02 radians per frame

    // calculate the position of circle 4 using trigonometry
    float x4 = cos(angle4) * (radius + rotationRadius4);
    float y4 = sin(angle4) * (radius + rotationRadius4);

    // set the fill color of circle 4 to yellow
    e.fill(255, 255, 0);

    // draw circle 4
    float r4 = 30; // for example, set the radius of circle 4 to 30 pixels
    e.ellipse(centerX + x4, centerY + y4, r4 * 2, r4 * 2);

    // increment the angle of circle 4 to make it rotate counter-clockwise
    angle4 -= 0.03; // for example, rotate at a rate of 0.03 radians per frame
  }

}


