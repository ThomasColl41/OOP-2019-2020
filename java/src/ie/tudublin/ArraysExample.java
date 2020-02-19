package ie.tudublin;

import java.util.Arrays; 
import java.util.Collections; 

import processing.core.PApplet;

public class ArraysExample extends PApplet
{	

	//float[] rainFall = new float[12]; 
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		for(int i = 0 ; i < rainFall.length; i ++)
		{
			println(months[i] + "\t" + rainFall[i]);
		}

		for(float f:rainFall)
		{
			println(f);
		}

		for(String s:months)
		{
			println(s);
		}

		int minIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] < rainFall[minIndex])
			{
				minIndex = i;
			}
		}
		println(months[minIndex] + " had the minimum rainfall of " + rainFall[minIndex]);
		
		int maxIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] > rainFall[maxIndex])
			{
				maxIndex = i;
			}
		}
		println(months[maxIndex] + " had the maximum rainfall of " + rainFall[maxIndex]);

		// You can also calculate the minimum and max of an arry this way:
		// Note the array is of type Float not float
		// Float are objects float is a primitive type
		Float[] floatArray = {10.0f, 5.0f, 20.0f};
		float min = Collections.min(Arrays.asList(floatArray)); 
        float max = Collections.max(Arrays.asList(floatArray));
	}

	void drawBarChart()
	{
		float w = width / (float) rainFall.length;
		float cGap = 255 / (float) rainFall.length;
		noStroke();
		colorMode(HSB);
		for(int i = 0 ; i < rainFall.length ; i ++)
		{
			float x = i * w;
			fill(i * cGap, 255, 255);
			rect(x, height, w, -rainFall[i]);
		}
	}

	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	

	public void draw()
	{	
		background(0);		
		colorMode(HSB);	

		drawBarChart();
	}
}
