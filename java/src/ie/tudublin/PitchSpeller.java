package ie.tudublin;

import java.lang.Math;
import processing.core.PApplet;

public class PitchSpeller extends PApplet
{
	float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
        , 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
    String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};

    int test = 1;

    public String spell(float frequency)
    {
        frequency = Math.abs(frequency);
        String spelling = "Spelling not found";
        int f_map;

        f_map = (int) map(frequency, frequencies[0], frequencies[frequencies.length - 1], 0, 16);

        spelling = spellings[f_map];

        return spelling;
    }
    public static void main(String[] args) {
        PitchSpeller ps = new PitchSpeller();
        println(ps.spell(330));
        println(ps.spell(420));
        println(ps.spell(1980));
    }

    public void draw()
    {
        if (test == 1)
        {
            PitchSpeller ps = new PitchSpeller();
            println(ps.spell(330));
            println(ps.spell(420));
            println(ps.spell(1980));
            test++;
        }
    }
}