package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import ddf.minim.ugens.Oscil;
import ddf.minim.ugens.Waves;
import processing.core.PApplet;

public class SoundSynthesis extends PApplet
{
    Minim minim;
    AudioOutput out;
    Oscil wave;
    Oscil wave2;
    Oscil wave3;
    Oscil wave4;

    public void settings()
    {
        size(500, 500);
        
    }

    public void setup()
    {
        minim = new Minim(this);

        out = minim.getLineOut();

        //A
        wave = new Oscil(440, 0.5f, Waves.SQUARE );
        wave.patch(out);
        //F
        wave2 = new Oscil( 349.23f, 0.5f, Waves.SQUARE );
        //wave2.patch(out);
        //E
        wave3 = new Oscil( 329.63f, 0.5f, Waves.SQUARE );
        //wave3.patch(out);
        //D
        wave4 = new Oscil(293.66f, 0.5f, Waves.SQUARE );
        //wave4.patch(out);
    }

    public void keyPressed() {
        if (key == ' ')
        {
            wave.setFrequency(wave.frequency.getLastValue() + 100);
        }
        println(wave.frequency.getLastValue());
    }

    float offset = 0;

    public void draw()
    {
        //wave.setFrequency(random(60, 2000));
        float n = noise(offset);
        // wave.setFrequency(
        //     map(n, 0, 1, 200, 600)
        // );
        // offset += 0.01f;

        float cx = width / 2;
        float cy = height / 2;

        background(0);
        stroke(255);
        noFill();
        ellipse(cx, cy, 300, 300);
        ellipse(cx, cy, 20, 20);
        ellipse(cx - 100, cy - 50, 20, map(n, 0, 1, 0, 60));
        ellipse(cx + 100, cy - 50, 20, map(n, 0, 1, 0, 60));

        ellipse(cx, cy + 100, 100,
            map(n, 0, 1, 0, 60)
        );

        line(cx - 150, cy, cx - 150, map(n, 0, 1, 0, 150));
        line(cx + 150, cy, cx + 150, map(n, 0, 1, 0, 150));

        // if(frameCount % 60 == 0)
        // {
        //     wave.patch(out);
        // }

        if(frameCount % 60 == 0)
        {
            wave.setFrequency(349.23f);
        }

        if(frameCount % 60 == 20)
        {
            wave.setFrequency(329.63f);
        }

        if(frameCount % 60 == 40)
        {
            wave.setFrequency(293.66f);
        }
    }
}