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

    public void settings()
    {
        size(500, 500);
        
    }

    public void setup()
    {
        minim = new Minim(this);

        out = minim.getLineOut();
        wave = new Oscil( 440, 0.5f, Waves.SQUARE );
        wave.patch(out);
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
        wave.setFrequency(
            map(n, 0, 1, 200, 600)
        );
        offset += 0.01f;

        float cx = width / 2;
        float cy = height / 2;

        background(0);
        stroke(255);
        noFill();
        ellipse(cx, cy, 300, 300);
        ellipse(cx, cy, 20, 20);
        ellipse(cx - 100, cy - 50, 20, 20);
        ellipse(cx + 100, cy - 50, 20, 20);

        ellipse(cx, cy + 100, 100,
            map(n, 0, 1, 0, 60)
        );
    }
}