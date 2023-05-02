package C21336753;

import ddf.minim.*;
import ddf.minim.analysis.*;
import ie.tudublin.Visual;


public class jon extends Visual {

    Star[] stars = new Star[200];
    float speed = 50;
    float centerX;
    float centerY;
    float angle1 = 0;
    float angle2 = PI;
    float angle3 = HALF_PI;
    float angle4 = 0;

    Circles circles;

    public void render(DON d) {
        
        d.background(0);





        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }

        circles = new Circles(d.width / 2, d.height / 2, d);

        float level = d.getAudioPlayer().mix.level();
        speed = d.map(level, 0, 1, 0, 20);

        for (int i = 0; i < stars.length; i++) {
            stars[i].update(speed, d);
            stars[i].show(speed, d);
        }

        circles.drawCircles(d.getFFT(), d.getAudioPlayer(), d);


    }

    class Circles {
        float[] rotationRadii = {200, 200, 200, 200};
        float[] circleDistances = {100, 120, 140, 160};
        float[] angles = {0, PI, HALF_PI, 0};
        float centerX;
        float centerY;

    
        Circles(float x, float y, DON d) {
            centerX = x;
            centerY = y;
        }
    
        void drawCircles(FFT fft, AudioPlayer audioPlayer, DON d) {
            fft.forward(audioPlayer.mix);
            int targetFrequencyBand = 200;
            float rotationSpeed = (float) (fft.getBand(targetFrequencyBand) * 0.1);
            
        
            float[] radii = {
                d.map(fft.getBand(100), 0, 100, 25, 300),
                d.map(fft.getBand(75), 0, 100, 35, 300),
                d.map(fft.getBand(120), 0, 100, 45, 300),
                d.map(fft.getBand(50), 0, 100, 55, 300)
            };
        
            int[] circleColors = {
                color(160, 32, 240),
                color(0, 102, 204, 180),
                color(255, 153, 0, 180),
                color(255, 0, 0, 180),
                color(51, 153, 102, 180)
            };
        
            // Draw the inner circle
            float innerRadius = 50;
            drawCircle(centerX, centerY, innerRadius, circleColors[0], d);
        
            // Draw the inner circle
            float x1 = centerX + cos(angle1) * (innerRadius + rotationRadii[0] + circleDistances[0]);
            float y1 = centerY + sin(angle1) * (innerRadius + rotationRadii[0] + circleDistances[0]);
            drawCircle(x1, y1, radii[0], circleColors[1], d);
            angle1 += rotationSpeed;
        
            // Draw the second circle
            float x2 = centerX + cos(angle2) * (innerRadius + rotationRadii[1] + circleDistances[1]);
            float y2 = centerY + sin(angle2) * (innerRadius + rotationRadii[1] + circleDistances[1]);
            drawCircle(x2, y2, radii[1], circleColors[2], d);
            angle2 -= rotationSpeed;
        
            // Draw the third circle
            float x3 = centerX + cos(angle3) * (innerRadius + rotationRadii[2] + circleDistances[2]);
            float y3 = centerY + sin(angle3) * (innerRadius + rotationRadii[2] + circleDistances[2]);
            drawCircle(x3, y3, radii[2], circleColors[3], d);
            angle3 += rotationSpeed;
        
            // Draw the fourth circle
            float x4 = centerX + cos(angle4) * (innerRadius + rotationRadii[3] + circleDistances[3]);
            float y4 = centerY + sin(angle4) * (innerRadius + rotationRadii[3] + circleDistances[3]);
            drawCircle(x4, y4, radii[3], circleColors[4], d);
            angle4 -= rotationSpeed;
        }
        
        
    
        void drawCircle(float x, float y, float radius, int fillColor, DON d) {
            d.fill(fillColor);
            d.ellipse(x, y, radius * 2, radius * 2);
        }
    }
    
    
    
    
    

    class Star {
        float x;
        float y;
        float z;
        float pz;
        float opacity = 255;
    
        Star() {
            x = random(-width * 2.5f, width * 2.5f);
            y = random(-height * 2.5f, height * 2.5f);
            z = random(width);
            pz = z;
        }
    
        void update(float speed, DON d) {
            z = z - speed;
            if (z < 1) {
                z = width;
                x = random(-width, width);
                y = random(-height, height);
                pz = z;
                opacity = 255;
            }
        }
    
        void show(float speed, DON d) {
            d.pushMatrix();
            d.translate(width / 2 + 400, height / 2 + 450);
    
            if (speed >= 1) {
                d.fill(255, opacity);
                d.noStroke();
    
                float sx = map(x / z, 0, 1, 0, width);
                float sy = map(y / z, 0, 1, 0, height);
    
                float r = map(z, 0, width, 16f, 0f);
    
                d.ellipse(sx, sy, r, r);
    
                float px = map(x / pz, 0, 1, 0, width);
                float py = map(y / pz, 0, 1, 0, height);
    
                d.stroke(255, opacity * 0.5f);
                d.line(px, py, sx, sy);
    
                px = x;
                py = y;
    
                opacity = map(speed, 20, 0, 255, 0);
            } else {
                opacity = 0;
            }
    
            d.popMatrix(); 
        }
    }
}