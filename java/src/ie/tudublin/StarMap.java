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

    public void drawStars()
    {
        for(Star s: stars)
        {
            s.render(this);
        }
    }

    public void drawGrid()
    {
        float border = width * 0.05f;

        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = -5 ; i <= 5 ; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);    
            
            fill(255);
            text(i, x, border / 2);
            text(i, border / 2, x);
        }
    }

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

    public Star starSelect()
    {
        Star selected = null;
        float border = width * 0.05f;

        for(Star s:stars)
        {
            if((map(s.getxG(), -5, 5, border, width - border) - 5 <= mouseX
            && map(s.getxG(), -5, 5, border, width - border) + 5 >= mouseX)
            && (map(s.getyG(), -5, 5, border, height - border) - 5 <= mouseY
            && map(s.getyG(), -5, 5, border, height - border) + 5 >= mouseY))
            {
                selected = s;
            }
        }

        return selected;
    }

    public void distCalc()
    {
        Star selected1 = null;
        Star selected2 = null;
        float distance = 0;
        float border = width * 0.05f;

        selected1 = starSelect();
        selected2 = starSelect();

        if(selected1 != null && selected2 != null)
        {
            distance = abs((selected1.getDistance() - selected2.getDistance()));
            displayResult("The distance between " + selected1.getDisplayName() + " and " + selected2.getDisplayName() + " is "
            + distance);

            selected1 = null;
            selected2 = null;
        }
    }

    public void displayResult(String result)
    {
        text(result, 0, height - 10);
    }

    public void draw()
    {
        background(0);
        drawGrid();
        drawStars();
        distCalc();
        displayResult("AAAAAAA");
    }

}
