import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon{
    private ArrayList <Point2D.Double> myPolygon;
    private DrawingTool pencil;

    // constructors
    public IrregularPolygon() 
    {
        myPolygon = new ArrayList<Point2D.Double>();    
    }

    // public methods
    public void add(Point2D.Double aPoint) 
    { 
        myPolygon.add(aPoint);
    }
    

    public void draw() 
    { 
        pencil.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
        pencil.up();
        pencil.down();
        pencil.foward();
        pencil.backward();
        pencil.turnLeft();
        pencil.turnRight(); 

        /**what does the draw method do?*/ 
    }

    public double distance(Point2D.Double p1, Point2D.Double p2)
    {
        // ((x2-x1)^2 +(y2-y1)^2)^1/2 
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y),2));
    }

    public double perimeter()
    { 
        if (myPolygon.size() < 3)
        {
            return 0;
        }       
        double perimeter = 0;

        for (int i = 0; i < myPolygon.size() - 1; i++)
        {
            perimeter += distance(myPolygon.get(i), myPolygon.get(i + 1)); 
            //perimeter = perimeter+ distance from next 2 point
        }     
        //perimeter += distance(myPolygon.get(myPolygon.size() - 1), myPolygon.get(0));
        return perimeter;

    }

    public double area() 
    {
        if (myPolygon.size() < 3)
        {
            return 0;
        }

        //need 2 loops bec
        double area = 0;        
        //(x0y1 + x1y2 + x2y3 + ... xn-1 y0)
        for (int i = 0; i < myPolygon.size() - 1; i++)
        {
            area += myPolygon.get(i).x * myPolygon.get(i + 1).y;
        }
        area += myPolygon.get(myPolygon.size() - 1).x * myPolygon.get(0).y;        
        
        //(-y0x1 - y1x2 - y2x3 - ... yn-1 x0))
        for (int i = 0; i < myPolygon.size() - 1; i++ )
        {
            area -= myPolygon.get(i).y * myPolygon.get(i + 1).x;
        }
        area -= myPolygon.get(myPolygon.size() - 1).y * myPolygon.get(0).x;     

        area = Math.abs(area / 2); //the 1/2 in front
        return area;        
    }
}