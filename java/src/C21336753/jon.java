package C21336753;

import ie.tudublin.Visual;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;
import processing.core.PConstants;

public class jon extends Visual {
  float radius;
  float angle1 = 0;
  float angle2 = PI;
  float angle3 = HALF_PI;
  float angle4 = 0;
  float rotationRadius1 = 75;
  float rotationRadius2 = 150;
  float rotationRadius3 = 235;
  float rotationRadius4 = 335;
  float centerX;
  float centerY;

  public void draw(DON d) {
    d.background(0); // set the background color to black
    d.noStroke(); // disable the stroke

    // Draw the stars behind the circles
    for (int i = 0; i < 800; i++) {
      // generate a random position for the star
      float x = d.random(d.width);
      float y = d.random(d.height);

      // generate a random size for the star
      float size = d.random(1, 4);

      // generate a random speed for the star
      float speed = d.random(0.1f, 0.5f); // change this line

      // update the star's position based on its speed
      x += speed;
      y += speed;

      // calculate the color of the star based on the distance from the center of the
      // screen
      float distance = d.dist(x, y, d.width / 2, d.height / 2);
      int color = d.color(255 - distance / 2, 255 - distance / 2, 255, 255);

      // set the fill color to the calculated color
      d.fill(color);

      // draw the star as an ellipse
      d.ellipse(x, y, size, size);
    }

    d.pushMatrix();

    // Calculate the amplitude of the audio
    d.calculateAverageAmplitude();

    // set the center coordinates and radius of the main circle
    centerX = 450.f;
    centerY = 450.f;
    radius = 100;

    // Multiply the smoothed amplitude by a larger value
    float scaledAmplitude = d.getSmoothedAmplitude() * 10;

    int red1 = (int) (255 * d.getSmoothedAmplitude()) + 100;
    int green1 = (int) (255 * (1 - d.getSmoothedAmplitude())) + 50;
    int blue1 = (int) (255 * d.getSmoothedAmplitude()) + 50;

    int red2 = (int) (255 * d.getSmoothedAmplitude()) + 50;
    int green2 = (int) (255 * d.getSmoothedAmplitude()) + 50;
    int blue2 = (int) (255 * (1 - d.getSmoothedAmplitude())) + 50;

    int red3 = (int) (255 * d.getSmoothedAmplitude()) + 50;
    int green3 = (int) (255 * d.getSmoothedAmplitude()) + 50;
    int blue3 = (int) (255 * d.getSmoothedAmplitude()) + 50;

    int red4 = (int) (255 * (1 - d.getSmoothedAmplitude())) + 50;
    int green4 = 255;
    int blue4 = (int) (255 * d.getSmoothedAmplitude()) + 50;

    // set the fill color of the outer circle to red
    d.fill(255, 0, 255);

    // draw the outer circle in the center of the screen
    float outerRadius = 50;
    d.ellipse(centerX, centerY, outerRadius * 2, outerRadius * 2);

    // calculate the position of circle 1 using trigonometry
    float x1 = cos(angle1) * (radius + rotationRadius1);
    float y1 = sin(angle1) * (radius + rotationRadius1);

    // set the fill color of circle 1
    d.fill(red1, green1, blue1);

    // draw circle 1
    float r1 = 20 * (1 + d.getSmoothedAmplitude());

    d.ellipse(centerX + x1, centerY + y1, r1 * 2, r1 * 2);

    // increment the angle of circle 1 to make it rotate clockwise
    angle1 += 0.05 * d.getSmoothedAmplitude();

    // calculate the position of circle 2 using trigonometry
    float x2 = cos(angle2) * (radius + rotationRadius2);
    float y2 = sin(angle2) * (radius + rotationRadius2);

    // set the fill color of circle 2
    d.fill(red2, green2, blue2);

    // draw circle 2
    float r2 = 30 * (1 + d.getSmoothedAmplitude());

    d.ellipse(centerX + x2, centerY + y2, r2 * 2, r2 * 2);

    // increment the angle of circle 2 to make it rotate counter-clockwise
    angle2 -= 0.03 * d.getSmoothedAmplitude();

    // calculate the position of circle 3 using trigonometry
    float x3 = cos(angle3) * (radius + rotationRadius3);
    float y3 = sin(angle3) * (radius + rotationRadius3);

    // set the fill color of circle 3
    d.fill(red3, green3, blue3);

    // draw circle 3
    float r3 = 40 * (1 + d.getSmoothedAmplitude());

    d.ellipse(centerX + x3, centerY + y3, r3 * 2, r3 * 2);

    // increment the angle of circle 3 to make it rotate counter-clockwise
    angle3 += 0.02 * d.getSmoothedAmplitude();

    // calculate the position of circle 4 using trigonometry
    float x4 = cos(angle4) * (radius + rotationRadius4);
    float y4 = sin(angle4) * (radius + rotationRadius4);

    // set the fill color of circle 4
    d.fill(red4, green4, blue4);

    // draw circle 4
    float r4 = 30 * (1 + d.getSmoothedAmplitude());
    d.ellipse(centerX + x4, centerY + y4, r4 * 2, r4 * 2);

    // increment the angle of circle 4 to make it rotate counter-clockwise
    angle4 -= 0.03 * d.getSmoothedAmplitude();

    d.popMatrix();
  }
}
