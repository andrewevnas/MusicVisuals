package C21336753;

import ie.tudublin.Visual;

public class DON extends Visual{
    public void settings()
    {
        size(1000, 1000, P3D);

        println("CWD: " + System.getProperty("user.dir"));
    }

    int mode = 1;
    boolean paused = true;

    public void keyPressed()
    {
        if (key >= '0' && key <= '4')
        {
		    mode = key - '0';
	    }

        switch (key)
        {
            case ' ':
            {
                if (paused)
                {
                    getAudioPlayer().play();
                    paused = false;
                }

                else
                {
                    getAudioPlayer().pause();
                    paused = true;
                }

                break;
            }

            case '1':
            {
                getAudioPlayer().play();
                break;
            }

            case 'r':
            {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
            }
        }
    }

    public void setup()
    {
        colorMode(HSB);
        // noCursor();


        
        setFrameSize(1024);
        frameRate(60);

        startMinim();
        loadAudio("song.mp3");

        getAudioPlayer().setGain(-10);
    }

    andrew Andrew = new andrew();
    jon Jon = new jon();
    david David = new david();
    Combined Combined = new Combined();

    public void draw()
    {    
        //background(255);

        //automate switching when the bass drops
        if(getAudioPlayer().position() >= 10000 && getAudioPlayer().position() <= 55800)
        {
            mode = 2;
        }
        if(getAudioPlayer().position() >= 20000 && getAudioPlayer().position() <= 92800)
        {
            mode = 3;
        }
        if(getAudioPlayer().position() >= 30000 && getAudioPlayer().position() <= 130000)
        {
            mode = 4;
        }

        if(getAudioPlayer().position() >= 40000 && getAudioPlayer().position() <= 155000)
        {
            mode = 5;
        } 



        switch(mode)
        {
            case 1: //david call 
            {
                David.render(this);
                break;
            }
            
            case 2: // jon call
            {
                Jon.render(this);
                break;
            }

            case 3: // andrew call
            {
                Andrew.render(this);
                break;
            }

            
            case 4: // combined call
            {
                 Combined.render(this);
                 break;
            }

           
        }
    }
}
