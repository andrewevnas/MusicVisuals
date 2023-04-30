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

    public andrew() 
    {
        startMinim();
        // load the song
        loadAudio("song.mp3");
        // create an FFT object to analyze the audio
        fft = new FFT(getAudioPlayer().bufferSize(), getAudioPlayer().sampleRate());
        
    }

    public void draw(DON e) 
    {
        e.background(0);
        e.stroke(255);
        e.noFill();
    
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
        e.colorMode(HSB);
        float hue = map(magnitude, 0, upperBandIndex - lowerBandIndex + 1, 200, 0);
        e.stroke(350, 100, hue);
    
        // move the cube to the center of the screen
        e.pushMatrix();
        e.translate(width / 2, height / 2, 0);
    
        // rotate the cube based on the mapped rotation speed
        e.rotateX(frameCount * rotationSpeed);
        e.rotateY(frameCount * rotationSpeed);
    
        // draw the cube with the mapped color
        e.box(200);
        
        e.popMatrix();
        frameCount++; // increment frame count to rotate the cube
    }

}
