// package C21336753;

// import ddf.minim.*;
// import processing.core.*;
// import ddf.minim.AudioPlayer;
// import ddf.minim.analysis.*;
// import processing.core.PApplet;

// public class david extends PApplet {

//     Minim minim;
//     AudioPlayer audioPlayer;
//     FFT fft;
//     float[] spectrum;

//     float angleX = 0;
//     float angleY = 0;
//     float angleZ = 0;

//     public void setup() {
//         size(640, 480, P3D);

    public void draw()
    {
      background(0,0,0);
      translate(width/2, height/2);
      for(int i=0; i<50000; i++)
      {
        fill(i*690, 351-i*29,86-i*90);
        scale((float) 0.95);
      
        rotate(radians(angle));
        float side = 600;
        float offset = side / 2;
        ellipse(side, side, side, side);
      }
      angle+=0.1;
    }
}

