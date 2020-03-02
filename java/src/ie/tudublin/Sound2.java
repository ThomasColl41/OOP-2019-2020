package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;

public class Sound2 extends PApplet
{	
	Minim minim;
	AudioSample as;

	float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
		, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
	String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", 
	"d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};

	int frameSize = 1024;

	/*
	Bryan's solution
	float frameToSecond = 44100 / (float) frameSize;
	*/

	public void settings()
	{
		size(1024, 500);
	}


	public void setup() 
	{
		minim = new Minim(this);
		as = minim.loadSample("scale.wav", frameSize);
		colorMode(HSB);
	}

	float lerpedw = 0;

	public void keyPressed()
	{
		as.stop();
		as.trigger();
	}

	public int countZeroCrossings()
	{
		int zeroCrossCount = 0;
		for(int i = 0 ; i < as.bufferSize() - 1 ; i++)
		{
			if (as.left.get(i) > 0 && as.left.get(i + 1) < 0)
			{
				zeroCrossCount++;
			}
		}
		return zeroCrossCount;
	}

	public String spell(float frequency)
	{
		String note = "";

		for(int i = 0; i < frequencies.length - 1; i ++)
		{
			float difference = frequencies[i + 1] - frequencies[i];

			if(frequency >= frequencies[i] && frequency < frequencies[i] + (difference / 2))
			{
				note = spellings[i];
			}
			else if(frequency <= frequencies[i + 1] && frequency > frequencies[i + 1] - (difference / 2))
			{
				note = spellings[i + 1];
			}
		}

		return note;
	}

	public void circularSound()
	{
		float theta = 0;
		float cx = width / 2;
		float cy = height / 2;
		float circX;
		float circY;

		for(int i = 0; i < as.bufferSize(); i++)
		{
			//float theta = map(i, 0, as.bufferSize(), 0, TWO_PI);
			stroke(
				map(i, 0, as.bufferSize(), 0, 255)
				, 255
				, 255
			);
			float radius = as.left.get(i);
			circX = (sin(theta) * radius) * cy;
			circY = (cos(theta) * radius) * cy;

			theta += TWO_PI / (float) as.bufferSize();

			line(cx, cy, circX + cx, circY + cy);
		}
	}

	/*
	Bryan's Solution
	public int countZeroCrossings()
	{
		int count = 0;
		for(int i = 1 ; i < as.bufferSize(); i++)
		{
			if (as.left.get(i-1) > 0 && as.left.get(i) <= 0)
			{
				zeroCrossCount++;
			}
		}
		return count;
	}
	*/
	
	public void draw()
	{	
		background(0);		
		stroke(255);
		textSize(32);
		float cy = height / 2;
		float sum = 0;
		for(int i = 0 ; i < as.bufferSize() ; i ++)
		{
			stroke(
				map(i, 0, as.bufferSize(), 0, 255)
				, 255
				, 255
			);
			//line(i, cy, i, cy + ai.left.get(i) * cy);
			sum += abs(as.left.get(i));
		}
		float average = sum / as.bufferSize();

		float w  = average * 1000;
		lerpedw = lerp(lerpedw, w, 0.1f);
		noStroke();
		fill(
			map(average, 0, 1, 0, 255)
			, 255
			, 255
		);
		//ellipse(400 , cy,w, w);
		//ellipse(600 , cy,lerpedw, lerpedw);

		float noteF = countZeroCrossings() * (1.0f/0.023f);
		String note = spell(noteF);
		
		text(noteF, 50, 50);
		text(note, 50, 100);

		/*
		Bryan's Solution
		int count = countZeroCrossings();

		float freq = count * freqTosecond;
		texySize(22);
		text(freq, 100, 50);
		*/

		circularSound();	
}
}
