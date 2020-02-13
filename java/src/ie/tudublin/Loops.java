package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	float centerX;
	float centerY;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		colorMode(HSB);
		centerX = 250;
		centerY = 250;
	}

	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}

	public void image1()
	{
		float cornerX = 0;
		float cornerY = 0;

		int i = 0;

		background(150);
		stroke(0);

		for (i = 0; i <= 25; i++)
		{
			line(cornerX, 0, centerX, centerY); //lines from the top
			line(0, cornerY, centerX, centerY); //lines from the left
			line(cornerX, 500, centerX, centerY); //lines from the bottom
			line(500, cornerY, centerX, centerY); //lines from the right

			cornerX += 20;
			cornerY += 20;
		}

		/*Bryan's Solution*/
		/*
		stroke(255);
		//int numLines = 100;
		int numLines = (int) (30 * (mouseX / (float) width));
		float gap = width / (float)numLines;
		for (int i = 0; i < numLines; i++)
		{
			float x = i * gap;
			line(x, 0, width - x, height);
			line(0, x, width, height - x);
		}
		*/
	}

	public void image2()
	{
		background(150);
		stroke(0);
		fill(255);

		float circleX = 25;

		//circles in the middle of the screen
		int i = 0;
		
		for (i = 0; i <= 10; i++)
		{
			ellipse(circleX, centerY, 50, 50);

			circleX += 50;
		}

		/*Bryan's Solution*/
		/*
		int numCircles = (int) (20 * (mouseX / (float) width));
		float w = width / (float) numCircles;
		float radius = w / 2.0f;
		colorMode(HSB);
		float cGap = 255 / (float)numCircles;
		noStroke();
		for(int i = 0; i < numCircles' i++)
		{
			float x = radius + (i * w);
			fill(cGap * i, 255, 255);
			ellipse(x, height / 2, w, w);
		}
		*/
	}

	public void image3()
	{
		float cornerX = 0;
		float cornerY = 0;
		float rectWidth = 255/5;
		float h = 0;

		int i = 0;

		background(255);
		noStroke();

		for (i = 0; i <= 10; i++)
		{
			fill(h, 255, 255);
			
			rect(cornerX, cornerY, rectWidth, height);

			cornerX += rectWidth;

			h += 20;
		}
	}

	public void image4()
	{
		background(255);
		noStroke();

		float circleX = 25;
		float h = 0;

		//circles in the middle of the screen
		int i = 0;
		
		for (i = 0; i <= 10; i++)
		{
			fill(h, 255, 255);
			ellipse(circleX, centerY, 50, 50);

			circleX += 50;
			h += 20;
		}
	}

	public void image5()
	{
		background(0);

		float gridX = 50;
		float gridY = 50;
		float gridCornerX = 50;
		float gridCornerY = 50;

		float textX = 50;

		int i = 0;
		int x = -5;

		textSize(12);

		for (i = 0; i < 11; i++)
		{
			stroke(75, 255, 255);
			line(gridCornerX, gridY, width - gridCornerX, gridY);
			line(gridX, gridCornerY, gridX, height - gridCornerY);

			text(x, textX, 30);
			text(x, 20, textX);

			x++;
			textX += 40;
			gridX += 40;
			gridY += 40;
		}

		/*Bryan's Solution*/
		/*
		float gap = width * 0.1f;
		float ahlfGap = gap / 2.0f;
		colorMode(RGB);
		stroke(0, 255, 0);
		textAlign(CENTER, CENTER);
		for (int i = -5; i <= 5; i++)
		{
			float x = map(i, -5, 5, gap, width - gap)
			line(x, gap, x, gap);
			line(gap, x, width - gap, x);
			fill(255);
			text(i, x, halfGap);
			text(i, halfGap, x);
		}
		*/
	}

	public void image6()
	{
		background(150);
		stroke(0);

		//start drawing at center
		float rectStartX = 250;
		float rectStartY = 250;
		float rectWidth = 100;
		float rectHeight = 25;
		float rectWidthDiff = 20;

		int i = 0;

		for (i = 0; i < 5; i++)
		{
			rect(rectStartX, rectStartY, rectWidth, rectHeight);

			rectWidth = rectWidth - rectWidthDiff;
			rectStartX = (rectStartX + (rectWidthDiff / 2));
			rectStartY = rectStartY + rectHeight;
		}
	}

	public void image7()
	{
		background(255);
		noStroke();

		float circleX = 25;
		float circleY = 25;
		float h = 0;

		int i = 0;
		int j = 0;
		
		for (i = 0; i <= 10; i++)
		{
			for (j = 0; j < 10; j++)
			{
				fill(h, 255, 255);
				ellipse(circleX, circleY, 50, 50);

				circleX += 50;
				h += 10;
			}

			h -= 90;
			circleX = 25;
			circleY += 50;
		}

		/*Bryan's Solution*/
		/*
		//outside of method but in the class ( a field)
		float offset = 0;
		int numCircles = (int) (20 * (mouseX / (float) width));
		float w = width / (float) numCircles;
		float radius = w / 2.0f;
		colorMode(HSB);
		float cGap = 255 / (float)(numCircles * numCircles);
		noStroke();
		for int j = 0; j < numCircles; j++)
		{
			for(int i = 0; i < numCircles' i++)
			{
				float x = radius + (i * w);
				float y = radius + (j * w);
				float c = (cGap * i * j + offset) % 255;
				fill(cGap * i * j, 255, 255);
				ellipse(x, height / 2, w, w);
			}
		}
		offset += mouseY / 250.0f;
		*/
	}

	public void image8()
	{
		noStroke();

		float rectWidth = 25;
		float blueX = 0;
		float blueY = 0;
		float dBlueX = 25;
		float dBlueY = 0;

		float h = 175;

		int i = 0;
		int j = 0;

		for (i = 0; i < 20; i++)
		{
			for (j = 0; j < 10; j++)
			{
				fill(h, 255, 255);
				rect((blueX % width), blueY, rectWidth, rectWidth);
				blueX += 50;

				fill(h, 255, 125);
				rect((dBlueX % width), dBlueY, rectWidth, rectWidth);
				dBlueX += 50;
			}

			blueX += 25;
			blueY += 25;
			dBlueX += 25;
			dBlueY += 25;
		}
	}


	public void draw()
	{	
		background(0);		
		/*stroke(255);
		line(10, 10, 100, 10);
		line(10, 20, 100, 20);
		line(10, 30, 100, 30);
		line(10, 40, 100, 40);

		for(int y = 10 ; y <= 40 ; y += 10)
		{
			line(200, y, 300, y);
		}

		int yy = 10;
		while(yy <= 40)
		{
			line(300, yy, 400, yy);
			yy += 10;
		}
		*/
		
		//image1();

		//image2();

		//image3();

		//image4();

		//image5();

		//image6();

		//image7();

		image8();
	}
}
