package C21336753;

import  ie.tudublin.Visual;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class andrew extends Visual {

    float angle = 540;
    float speed = 0.05f;
    float alpha = 255;  // initialize stroke alpha to 255
    float alphaDecayRate = 255/60;

    public void draw( DON e) 
    {
        e.calculateAverageAmplitude();
        e.stroke(DON.map(e.getSmoothedAmplitude(), 0, 0.6f, 0, 255), 255, 255, alpha);
        e.strokeWeight(5);
        

        e.pushMatrix();

        e.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        e.translate(0, 0, -200);
        e.rotateX(angle);
        e.rotateZ(angle);       

        float boxSize = 10 + (120 * e.getSmoothedAmplitude()); 
        e.box(boxSize);

        e.popMatrix();

        angle += speed * 0.5f;

        alpha -= alphaDecayRate; // decrement alpha by the decay rate at each frame
        alpha = max(0, alpha); // ensure alpha does not become negative

        
    }

}
