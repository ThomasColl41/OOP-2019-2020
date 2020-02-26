package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;

public class Sound2 extends PApplet
{	
	Minim minim;
	AudioSample as;

	int frameSize = 1024;

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
	
	public void draw()
	{	
		background(0);		
		stroke(255);
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
		ellipse(400 , cy,w, w);
		ellipse(600 , cy,lerpedw, lerpedw);		
}
}
