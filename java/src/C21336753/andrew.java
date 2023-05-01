package C21336753;

import  ie.tudublin.Visual;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class andrew extends Visual {

    float angle = 540;
    float speed = 0.05f;
    float smoothedAmplitude = 0;
    

    public void drawCube(DON e) 
    {
        e.calculateAverageAmplitude();
        e.stroke(DON.map(e.getSmoothedAmplitude(), 0, 0.6f, 0, 255), 255, 255);
        e.strokeWeight(5);
        e.noFill(); // set no fill color
        

        e.pushMatrix();

        e.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        e.translate(0, 0, -200);
        e.rotateX(angle);
        e.rotateZ(angle);       

        float boxSize = 10 + (120 * e.getSmoothedAmplitude()); 
        e.box(boxSize);

        e.popMatrix();

        angle += speed * 0.5f;
    }

    public void drawBorder(float smoothedAmplitude, float colour, DON e) {
        float border = DON.map(smoothedAmplitude, 0, 0.15f, 3, 70);
        int color = e.color(DON.map(e.getSmoothedAmplitude(), 0, 0.6f, 0, 255), 255, 255);
        e.stroke(color);
        e.strokeWeight(border/5);
        e.fill(color, 150);
        e.rect(0, 0, e.width, border); // Top
        e.rect(e.width - border, 0, border, e.height); // Right
        e.rect(0, e.height - border, e.width, border); // Bottom
        e.rect(0, 0, border, e.height); // Left
    }
    
    

    public void render(DON e)
    {
        e.colorMode(Visual.HSB);
        e.background(0);
        smoothedAmplitude = e.getSmoothedAmplitude() / 8;

        drawBorder(smoothedAmplitude, ADD, e);

        drawCube(e);
    }



}
