package C21336753;

import  ie.tudublin.Visual;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class andrew extends Visual {

    float angle = 540;
    float speed = 0.05f;
    

    public void draw( DON e) 
    {
        e.calculateAverageAmplitude();
        e.stroke(DON.map(e.getSmoothedAmplitude(), 0, 0.6f, 0, 255), 255, 255);
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

        
        
    }

}
