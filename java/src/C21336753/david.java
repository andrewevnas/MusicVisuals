package C21336753;

import ie.tudublin.*;
import processing.core.PApplet;
import java.util.ArrayList;

//main class for visual
public class david extends Visual
{
    //declaring x initialising variables
    float angle = 0;
    float side;
    float angleCube = 200;
    float angleBigCube = 360;
   
    float speed = 0.02f;
    float BigSpeed = 0.02f;
   
    float smoothedAmplitude = 0;
    int width;

    //function to draw the spiral
    public void drawSpiral(DON c)
    {
       //setting up env
        c.translate(c.width / 2, c.height / 2);  
        c.stroke(0);
        c.strokeWeight(3);
     
        //for loop 4 color changes to spiral
        for (int i = 0; i < 1000; i++)
        {
            //calculating color comp for multicolor
            float red = (float) c.map(c.sin(c.radians(angle)), -1, 1, 180, 232);
            float green = (float) c.map(c.cos(c.radians(angle)), -1, 1, 192, 120);
            float blue = (float) c.map(c.cos(c.radians(angle)), -1, 1, 203, 255);
           
            //set color and draw ellipse
            c.fill(DON.map(c.getSmoothedAmplitude(), 0, 0.6f, 0, 255), 255, 255);
            c.scale((float) 0.95);
            c.rotate(c.radians(angle));
            float side = 90;
            float offset = side / 2;
            c.ellipse(side, 0, side, side);
        }
        //updating angle
        angle += 0.17;
       
    }


    //rotating cube f()
    public void drawCube(DON c)
    {
        //calc amp x setting up env
        c.calculateAverageAmplitude();
        c.stroke(255);
        c.strokeWeight(6);
        c.noFill(); // set no fill color
       

        //set up transformation and draw cube
        c.pushMatrix();
        c.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        c.translate(0, 0, -200);
        c.rotateX(angleCube);
        c.rotateZ(angleCube);      

        //drawing cool cube x restoring the change
        float boxSize = 65 ;
        c.box(boxSize);

        c.popMatrix();

        //updating cube rotation angle
        angleCube += speed * 0.7f;
    }

    //bigger cube()
    public void drawBigCube(DON c)
    {
        //calc amp x setting up env
        c.calculateAverageAmplitude();
        c.stroke(DON.map(c.getSmoothedAmplitude(), 0, 0.6f, 0, 255), 255, 255);
        c.strokeWeight(3);
        c.noFill();// set no fill color
       
        // Set up transformation and draw cube
        c.pushMatrix();
        c.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        c.translate(0, 0, -200);
        c.rotateX(angleBigCube);
        c.rotateZ(angleBigCube);      

        // Draw cube with size based on amplitude and restore transformation
        float boxSize = 100 + (120 * c.getSmoothedAmplitude());  
        c.box(boxSize);

        c.popMatrix();

        angleBigCube += BigSpeed * 0.7f;
    }

    public void drawBorder(float smoothedAmplitude, float colour, DON c) {
        //e.background(0);
        float border = DON.map(smoothedAmplitude, 0, 0.15f, 3, 70);
        int color = c.color(240);
        c.stroke(color);
        c.strokeWeight(border/5);
        c.fill(color, 150);
        c.rect(0, 0, c.width, border); // Top
        c.rect(c.width - border, 0, border, c.height); // Right
        c.rect(0, c.height - border, c.width, border); // Bottom
        c.rect(0, 0, border, c.height); // Left
    }

   

    public void render(DON c){

        c.colorMode(Visual.HSB);
        c.background(0);
        smoothedAmplitude = c.getSmoothedAmplitude() / 3;
        drawBorder(smoothedAmplitude, ADD, c);
        drawCube(c);
        drawSpiral(c);
       
        drawBigCube(c);
       
       
    }
}