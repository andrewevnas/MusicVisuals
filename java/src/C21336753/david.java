package C21336753;

import ddf.minim.*;
import processing.core.*;
import ddf.minim.AudioPlayer;
import ddf.minim.analysis.*;
import processing.core.PApplet;

public class david extends PApplet {

    Minim minim;
    AudioPlayer audioPlayer;
    FFT fft;
    float[] spectrum;

    float angleX = 0;
    float angleY = 0;
    float angleZ = 0;

    public void setup() {
        size(640, 480, P3D);

        minim = new Minim(this);
        audioPlayer = minim.loadFile("song.mp3");
        audioPlayer.loop();
    }

    public void draw() {
        background(255);
        lights();
        stroke(0);
        noFill();

        fft.analyze();
        spectrum = fft.spectrum();

        float bass = spectrum[0];
        float treble = spectrum[spectrum.length - 1];

        angleX += map(bass, 0, 255, 0.01, 0.5);
        angleY += map(treble, 0, 255, 0.01, 0.5);
        angleZ += 0.01;

        pushMatrix();
        translate(width / 2, height / 2, 0);
        rotateX(angleX);
        rotateY(angleY);
        rotateZ(angleZ);
        box(100);
        popMatrix();
    }

}
