### Music Visualiser Project


## Members of the Group

| Name | Student Number |
|-----------|-----------|
| Jon Kehoe | C21372766 |
| Andrew Evans | C21336753 |
| David Udoh | C21455002 |




## Video Of Our Visualisation

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)


## Description of the assignment
For this assignemnt we were given a task to create a music visual for a song of our choice. The visuals we created were to reflect the mood, rythm and tempo of the song. 

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet
- press f5 to see music visuals
- press space to start visuals
- press 1 - 5 to switch between different visuals


## How it works 

Throughtout this project used the file structure of "Individuel Visuslisers" being then passed to a "Parent" class called DON.java. Each of these visuals send their own information to DON using a variation of "render" method. DON is run from main.java. In each visualiser we extend Visual.java which include "preset" methods based on PApplet. Within DON.java we declare each each personal class or visual as a new name with a Capital letter to distinguish ie. Jon and jon. Each of these is this run using a switch case mode dependent of key strokes between 1-4.

```Java
andrew Andrew = new andrew();
jon Jon = new jon();
david David = new david();
Combined Combined = new Combined();
```



```Java
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

        
```


# Section 1 David
In my visualiser, I created a multi colour spiral with two cubes, one larger and one smaller cube that jump to the amplitude of the song. Also surrounding the screen I’ve implemented a border that expands and retracts also to the amplitude of the song. My aim with the two rotating cubes was to create something similar to an optical illusion to really encapsulate the beat of the song as in my opinion the beat of the song is very relaxing and soothing.

![An image](images/p8.png)

# Section 2 Jon
In my visuliser i have made a visual using circles and stars, the circles are supposed to represent the planets in the solar system which are rotating clockwise and anti-clockwise. There is four rotating planets which are represented by differnt colours and they show up as a trandsparent planets, this allows the stars to be seen behind them. The circles rotate to the speed of the amplitude of the song and get larger to the amplitude of the song also. The stars appear faster ot the amplitude of the song giving it an effect that its traveling through space like a space warp affect.

![An image](images/p8.png)


# Section 3 Andrew
In my visual I decided to incoporate a minimalist approach due to the laid back nature of the song. My main "character" is a 3D cube which reacts to the amplitude of the track and expands when amplitude increases. As design features I added four pyramids that rotate at a very quick, distorted pace, again, due to the amplitude of the song. Lastly I incoporated a spiral pattern in the background and also a coloured border that extends slightly to amplitude.

![An image](images/p8.png)

# Section 4 Combined
In this visual we decided to take our favourite parts of each of our individual visuals and combined it to go the extra mile. This is an example of us working together as a team as well as creating our own personal visuals.

![An image](images/p8.png)


# What we am most proud of in the assignment

The visualizations are classified into separate classes, all of which are contained within a single package. The "DON.java" file functions as the driver for the project, and four visual objects were instantiated. Inheritance was utilized to enable the usage of methods such as "calculateAverageAmplitude()" from the "Visual" class. The "setup" method was used to load in the "song.mp3" file using "minim".