package C21336753;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class andrew extends Visual {

    private FFT fft;
    private float[] boxSizes; // array to store the current size of each box
    private float[] fillColors; // array to store the current fill color of each box
    private float rotationSpeed;

    public void settings() {
        size(800, 800, P3D);
    }

    public void setup() {
        startMinim();
        // load the song
        loadAudio("song.mp3");
        // create an FFT object to analyze the audio
        fft = new FFT(getAudioPlayer().bufferSize(), getAudioPlayer().sampleRate());
        // initialize the arrays with the initial values
        boxSizes = new float[5];
        fillColors = new float[5];
        for (int i = 0; i < 5; i++) {
            boxSizes[i] = 50;
            fillColors[i] = 200;
        }
        // start playing the song
        getAudioPlayer().play();
    }

    public void draw() {
        background(0);
        stroke(255);
        noFill();

        // analyze the audio and get the magnitudes of several frequency ranges
        fft.forward(getAudioPlayer().mix);
        float[] magnitudes = new float[5];
        for (int i = 0; i < magnitudes.length; i++) {
            int lowerBandIndex = fft.freqToIndex(i * 200);
            int upperBandIndex = fft.freqToIndex((i + 1) * 200);
            for (int j = lowerBandIndex; j <= upperBandIndex; j++) {
                magnitudes[i] += fft.getBand(j);
            }
        }

        // move the center of the coordinate system to the center of the screen
        pushMatrix();
        translate(width / 2, height / 2, 0);

        // draw multiple boxes with different sizes and colors based on the magnitudes
        colorMode(HSB);
        for (int i = 0; i < magnitudes.length; i++) {
            float hue = map(magnitudes[i], 0, fft.getBandWidth() * (i + 1), 200, 0);
            float size = map(magnitudes[i], 0, fft.getBandWidth() * (i + 1), 50, 400);
            float lerpHue = lerp(fillColors[i], hue, 0.1f); // interpolate between the current hue and the mapped hue
            float lerpSize = lerp(boxSizes[i], size, 0.1f); // interpolate between the current size and the mapped size
            fill(lerpHue, 255, 255);
            pushMatrix();
            rotateY(frameCount * 0.01f * (i + 1));
            box(lerpSize);
            popMatrix();
            fillColors[i] = lerpHue; // update the current hue
            boxSizes[i] = lerpSize; // update the current size
        }

        popMatrix();
        frameCount++; // increment frame count to rotate the boxes
    }
}
