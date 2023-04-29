package C21336753;

import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class jon extends PApplet {

  Minim minim;
  AudioPlayer audioPlayer;
  FFT fft;

  Star[] stars = new Star[800];
  float speed = 10;

  float centerX, centerY; // center coordinates of the main circle
  float radius; // radius of the main circle
  float angle1 = 0; // initial angle of rotation for circle 1 (clockwise)
  float angle2 = PI; // initial angle of rotation for circle 2 (counter-clockwise)
  float angle3 = HALF_PI; // initial angle of rotation for circle 3 (counter-clockwise)
  float angle4 = 0;
  float rotationRadius1 = 75; // radius of circle 1
  float rotationRadius2 = 150; // radius of circle 2
  float rotationRadius3 = 225; // radius of circle 3
  float rotationRadius4 = 325; // radius of circle 3

  public void settings() {
    size(900, 900);
  }

  public void setup() {
    size(900, 900); // set the size of the window to 500x500 pixels

    minim = new Minim(this);
    audioPlayer = minim.loadFile("song.mp3");
    audioPlayer.loop();

    fft = new FFT(audioPlayer.bufferSize(), audioPlayer.sampleRate());

    for (int i = 0; i < stars.length; i++) {
      stars[i] = new Star(this);
    }
    

    // set the center coordinates and radius of the main circle
    centerX = width / 2;
    centerY = height / 2;
    radius = 100; // for example, set the radius to 100 pixels
  }

  public void draw() {
    // Add this line before the background function to create a tracer effect
    blendMode(ADD);
    background(0, 0, 0, 15); // Add an alpha value to the background color to control the trail length

    fft.forward(audioPlayer.mix);
    int targetFrequencyBand = 200;
    float rotationSpeed = (float) (fft.getBand(targetFrequencyBand) * 0.1);

    // Calculate the radius of circles 1, 2, 3, and 4 based on frequency bands
    float r1 = map(fft.getBand(100), 0, 100, 25, 300);
    float r2 = map(fft.getBand(75), 0, 100, 35, 300);
    float r3 = map(fft.getBand(120), 0, 100, 45, 300);
    float r4 = map(fft.getBand(50), 0, 100, 55, 300);

    // translate(width/2, height/2);
    float level = audioPlayer.mix.level();
    speed = map(level, 0, 1, 0, 20);
    for (int i = 0; i < stars.length; i++) {
      stars[i].update(speed);
      stars[i].show(speed);
    }

    // set the fill color of the outer circle to red
    fill(160, 32, 240);

    // draw the outer circle in the center of the screen
    float radius = 50; // set the radius of the outer circle to 50 pixels
    ellipse(centerX, centerY, radius * 2, radius * 2);

    // calculate the position of circle 1 using trigonometry
    float x1 = centerX + cos(angle1) * (radius + rotationRadius1);
    float y1 = centerY + sin(angle1) * (radius + rotationRadius1);

    // set the fill color of circle 1 to blue
    fill(0, 102, 204, 180);

    // draw circle 1
    ellipse(x1, y1, r1 * 2, r1 * 2);

    // increment the angle of circle 1 to make it rotate clockwise
    angle1 += rotationSpeed; // for example, rotate at a rate of 0.05 radians per frame

    // calculate the position of circle 2 using trigonometry
    float x2 = centerX + cos(angle2) * (radius + rotationRadius2);
    float y2 = centerY + sin(angle2) * (radius + rotationRadius2);

    // set the fill color of circle 2 to orange
    fill(255, 153, 0, 180);

    // draw circle 2
    ellipse(x2, y2, r2 * 2, r2 * 2);

    // increment the angle of circle 2 to make it rotate counter-clockwise
    angle2 -= rotationSpeed; // for example, rotate at a rate of 0.03 radians per frame

    // calculate the position of circle 3 using trigonometry
    float x3 = centerX + cos(angle3) * (radius + rotationRadius3);
    float y3 = centerY + sin(angle3) * (radius + rotationRadius3);

    // set the fill color of circle 3 to green
    fill(255, 0, 0, 180);

    // draw circle 3
    ellipse(x3, y3, r3 * 2, r3 * 2);

    // increment the angle of circle 3 to make it rotate counter-clockwise
    angle3 += rotationSpeed; // for example, rotate at a rate of 0.02 radians per frame

    // calculate the position of circle 4 using trigonometry
    float x4 = centerX + cos(angle4) * (radius + rotationRadius4);
    float y4 = centerY + sin(angle4) * (radius + rotationRadius4);

    // set the fill color of circle 4 to red
    fill(51, 153, 102, 180);

    // draw circle 4
    ellipse(x4, y4, r4 * 2, r4 * 2);

    // increment the angle of circle 4 to make it rotate counter-clockwise
    angle4 -= rotationSpeed; // for example, rotate at a rate of 0.03 radians per frame
  }

}

class Star {
  float x;
  float y;
  float z;

  float pz;
  float opacity = 255;
  PApplet p;

  Star(PApplet p) {
    this.p = p;
    x = p.random(-p.width, p.width);
    y = p.random(-p.height, p.height);
    z = p.random(p.width);
    pz = z;
  }

  void update(float speed) {
    z = z - speed;
    if (z < 1) {
      z = p.width;
      x = p.random(-p.width, p.width);
      y = p.random(-p.height, p.height);
      pz = z;
    }

  void show(float speed) {
    p.noStroke();

    p.beginShape();
    p.fill(255, opacity);

    float sx = p.map(x / z, 0, 1, 0, p.width) + p.width / 2;
    float sy = p.map(y / z, 0, 1, 0, p.height) + p.height / 2;

    float r = p.map(z, 0, p.width, 16, 0);
    p.ellipse(sx, sy, r, r);

    float px = p.map(x / pz, 0, 1, 0, p.width) + p.width / 2;
    float py = p.map(y / pz, 0, 1, 0, p.height) + p.height / 2;

    p.stroke(255, opacity);
    p.line(px, py, sx, sy);

    px = x;
    py = y;

    opacity = p.map(speed, 20, 0, 255, 0);

    p.endShape();
  }

}
