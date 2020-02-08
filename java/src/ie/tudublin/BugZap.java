package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{	
    float playerX;
    float playerY;
    float playerWidth;
    float bugX;
    float bugY;
    float bugWidth;
	public void settings()
	{
        size(500, 500);
        
        playerX = (width / 2);
        playerY = height;
        playerWidth = 50;
        bugX = width;
        bugY = 0;
        bugWidth = 20;
	}

	public void setup() {
	}

	public void drawPlayer(float x, float y, float w) {
        double h = (w * 0.5);
        stroke(255,255,255);
        fill(255,255,255);
        rect(x - 25, y - 15, w, 15);
        line(x, y - 15, x, y - 25);
    }

    public void drawBug(float x, float y, float w) {
		textSize(32);
		text("?", bugX, bugY);
	}
	
	public void moveBug()
	{
		if (frameCount % 90 == 0)
		{
			bugY = bugY + 20;
			bugX = random(100, 400);
		}

		if (bugY == playerY)
		{
			bugY = 0;
		}
	}

    public void keyPressed()
	{
		if (keyCode == LEFT)
		{
            if (playerX != 0) {
                playerX = playerX - 10;
            }
		}
		if (keyCode == RIGHT)
		{
            if (playerX != 500) {
                playerX = playerX + 10;
            }
		}
		if (key == ' ')
		{
            line(playerX, playerY, playerX, 0);
		}
	}	
	
	public void draw()
	{	
        background(0);
        drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY, bugWidth);
		moveBug();
        
        
	}
}
