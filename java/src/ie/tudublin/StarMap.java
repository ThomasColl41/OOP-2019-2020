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

    public void draw()
    {

    }

}
