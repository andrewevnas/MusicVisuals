package C21336753;

import  ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class andrew extends Visual {

    private FFT fft;
    private float rotationSpeed;

    public void settings() 
    {
        size(800, 800, P3D);
    }

    public void setup() 
    {
        startMinim();
        // load the song
        loadAudio("song.mp3");
        // create an FFT object to analyze the audio
        fft = new FFT(getAudioPlayer().bufferSize(), getAudioPlayer().sampleRate());
        // start playing the song
        getAudioPlayer().play();
    }

    public void draw() 
    {
        background(0);
        stroke(255);
        noFill();
    
        // analyze the audio and get the magnitude of the desired frequency range
        fft.forward(getAudioPlayer().mix);
        int lowerBandIndex = fft.freqToIndex(600);
        int upperBandIndex = fft.freqToIndex(6000);
        float magnitude = 0;
        for (int i = lowerBandIndex; i <= upperBandIndex; i++) {
            magnitude += fft.getBand(i);
        }
    
        // map the magnitude to a rotation speed (in this example, between 0.01f and 0.1f)
        rotationSpeed = map(magnitude, 0, upperBandIndex - lowerBandIndex + 1, 0.01f, 0.01f);
    
        // map the magnitude to a color
        colorMode(HSB);
        float hue = map(magnitude, 0, upperBandIndex - lowerBandIndex + 1, 200, 0);
        stroke(350, 100, hue);
    
        // move the cube to the center of the screen
        pushMatrix();
        translate(width / 2, height / 2, 0);
    
        // rotate the cube based on the mapped rotation speed
        rotateX(frameCount * rotationSpeed);
        rotateY(frameCount * rotationSpeed);
    
        // draw the cube with the mapped color
        box(200);
        
        popMatrix();
        frameCount++; // increment frame count to rotate the cube
    }

}
