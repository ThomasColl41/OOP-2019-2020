package ie.tudublin;

import java.util.Arrays; 
import java.util.Collections; 

import processing.core.PApplet;

public class ArraysExample extends PApplet
{	

	//float[] rainFall = new float[12]; 
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	float originX = 50;
	float originY = 450;
	float yAxisX = originX;
	float yAxisY = originX;
	float xAxisX = originY;
	float xAxisY = originY;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		for(int i = 0 ; i < rainFall.length; i ++)
		{
			//println(months[i] + "\t" + rainFall[i]);
		}

		for(float f:rainFall)
		{
			//println(f);
		}

		for(String s:months)
		{
			//println(s);
		}

		int minIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] < rainFall[minIndex])
			{
				minIndex = i;
			}
		}
		//println(months[minIndex] + " had the minimum rainfall of " + rainFall[minIndex]);
		
		int maxIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] > rainFall[maxIndex])
			{
				maxIndex = i;
			}
		}
		//println(months[maxIndex] + " had the maximum rainfall of " + rainFall[maxIndex]);

		// You can also calculate the minimum and max of an array this way:
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

	void drawTrendLine()
	{
		drawAxes();
		textSize(12);
		stroke(130, 255, 255);

		float graphWidth = originY - originX;
		float graphWidthGap = graphWidth / (months.length - 1);
		float valuesX = originX;
		float valueY1;
		float valueY2;
		float yAxisTop = 450;

		for(int i = 0; i < (rainFall.length - 1); i++)
		{
			valueY1 = map(rainFall[i], 0, 150, yAxisTop, originX);
			valueY2 = map(rainFall[i + 1], 0, 150, yAxisTop, originX);

			line(valuesX, valueY1, (valuesX + graphWidthGap), valueY2);

			valuesX += graphWidthGap;
		}
	}

	void drawAxes() {
		stroke(255, 0, 255);
		int numYValues = 16;
		int yValue = 0;

		float graphWidth = originY - originX;
		float graphHeight = graphWidth;
		float graphWidthGap = graphWidth / (months.length - 1);
		float graphHeightGap = graphHeight / ((float)numYValues - 1);
		float yAxisValues = originX - 5;
		float xAxisValues = originY + 5;
		float monthsX = originX;
		float monthsY = originY + 20;
		float yValuesY = originY;
		float yValuesX = originX - 20;

		line(originX, originY, yAxisX, yAxisY);
		line(originX, originY, xAxisX, xAxisY);

		textAlign(CENTER);
		for(int i = 0; i < months.length; i++)
		{
			text(months[i], monthsX, monthsY);
			line(monthsX, originY, monthsX, xAxisValues);
			monthsX += graphWidthGap;
		}

		textAlign(RIGHT);
		for(int i = 0; i < numYValues; i++)
		{
			text(yValue, yValuesX, yValuesY);
			line(originX, yValuesY, yAxisValues, yValuesY);
			yValuesY -= graphHeightGap;
			yValue += 10;
		}
	}

	//Bryan's solution to trend line graph
	void drawLineGraph()
	{
		float border = width * 0.1f;

		textAlign(CENTER, CENTER);
		fill(255);
		stroke(255);
		line (border, border, border, height - border);
		for(int ya = 0; ya <= 150; ya += 10)
		{
			float y = map(ya, 0, 150, height - border, border);
			line(border, y, border - 5, y);
			text(ya, border / 2, y);
		}

		line(border, height - border, width - border, height - border);
		for(int i = 0; i < months.length ; i++)
		{
			float x = map(i, 0, months.length-1, border, width - border);
			line(x, height - border, x, height - border + 5);
			text(months[i], x, height - border / 2);
		}

		for(int i = 0; i < rainFall.length - 1; i++)
		{
			stroke(130, 255, 255);
			float x1 = map(i, 0, months.length-1, border, width - border);
			float x2 = map(i + 1, 0, months.length - 1, border, width - border);

			float y1 = map(rainFall[i], 0, 150, height - border, border);
			float y2 = map(rainFall[i + 1], 0, 150, height - border, border);

			line(x1, y1, x2, y2);
		}
	}

	void drawPieChart()
	{
		float cGap = 0.0f;
		float center= 250;
		float totalRainFall = 0.0f;
		for(int i = 0; i < rainFall.length; i++)
		{
			totalRainFall = totalRainFall + rainFall[i];
		}

		float startAngle = 0.0f;
		float nextAngle = 0.0f;
		float arcWidth = 250.0f;
		float rain = 0.0f;
		for(int i = 0; i < rainFall.length; i++)
		{
			fill(cGap,255,255);
			startAngle = map(rain, 0, totalRainFall, 0, TWO_PI);
			nextAngle = map(rain + rainFall[i], 0, totalRainFall, 0, TWO_PI);
			arc(center, center, arcWidth, arcWidth, startAngle, nextAngle, PIE);
			rain += rainFall[i];
			cGap += 255 / rainFall.length - 1;
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

		//drawBarChart();
		//drawTrendLine();
		//drawLineGraph();
		drawPieChart();
	}
}
