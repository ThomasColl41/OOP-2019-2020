package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
    // Arraylist can grow and shrink
    // Generic
    ArrayList<Star> stars = new ArrayList<Star>(); 

    public void settings()
    {
        size(800, 800);

    }

    public void setup()
    {
        loadData();
        printStars();
    }

    public void loadData()
    {
        Table t = loadTable("HabHYG15ly.csv", "header");
        for(TableRow tr:t.rows())
        {
            Star s = new Star(tr);
            stars.add(s);
        }
    }

    public void printStars()
    {
        for(Star s:stars)
        {
            println(s);
        }
    }

    /*Bryan's Solution
    public void drawStars()
    {
        for(Star s:stars())
        {
            s.render(this);
        }
    }
    
    public void drawGrid()
    {
        float border = width * 0.05f;

        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = -5; i <= 5; i++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
        }

        fill(255);
        text(i, x, border / 2);
        text(i, border / 2, x);
    } 
    */

    public void draw()
    {
        colorMode(HSB);
        background(0);
        textSize(14);
        textAlign(CENTER, CENTER);
        stroke(150, 255, 255);
        float gridCorner = 50;
		int x = -5;
		for (int i = 0; i <= 10; i++)
		{
            line(
                gridCorner, 
                map(i, 0, 10, gridCorner, width - gridCorner),
                width - gridCorner, 
                map(i, 0, 10, gridCorner, width - gridCorner)
            );

            line(
                map(i, 0, 10, gridCorner, width - gridCorner), 
                gridCorner,
                map(i, 0, 10, gridCorner, width - gridCorner), 
                height - gridCorner
            );

            text(
                x,
                map(i, 0, 10, gridCorner, width - gridCorner),
                gridCorner / 2
            );

            text(
                x,
                gridCorner / 2,
                map(i, 0, 10, gridCorner, width - gridCorner)
            );

			x++;
        }
        
        /*Bryan's Solution
        background(0);
        drawGrid();
        */
    }

}
