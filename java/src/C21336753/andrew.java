package C21336753;
import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class andrew extends Visual {
    
    public void settings() {
        size(800, 800, P3D);
    }

    public void setup() {
        startMinim();
        // load the song
        loadAudio("song.mp3");
        // start playing the song
        getAudioPlayer().play();
    }

    public void draw() {
        background(0);
        stroke(255);
        noFill();
    
        // calculate the tempo of the song
        try {
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        float tempo = getSmoothedAmplitude() * 100;
    
        // move the cube to the center of the screen
        pushMatrix();
        translate(width / 2, height / 2, 0);
    
        // rotate the cube based on the tempo of the song
        rotateX(frameCount * 0.01f * tempo);
        rotateY(frameCount * 0.01f * tempo);
    
        // draw the cube
        box(200);
    
        popMatrix();
        frameCount++; // increment frame count to rotate the cube
    }
    

}
