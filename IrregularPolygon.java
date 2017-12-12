import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon
{
    private static String name = "Sarah Sullivan";
    public String getName()
    {
        return name;
    }    
    private ArrayList <Point2D.Double> myPolygon;
    private SketchPad myPaper;
    private DrawingTool myPencil;

    // constructors
    public IrregularPolygon() 
    {
        myPolygon = new ArrayList<Point2D.Double>();    
        myPaper = new SketchPad(500,500);
        myPencil = new DrawingTool(myPaper);
    }

    // public methods
    public void add(Point2D.Double aPoint) 
    { 
        myPolygon.add(aPoint);
    }
    
    public void draw() 
    { 
        for (int i=0; i<myPolygon.size()-1; i++)
        {
            Point2D.Double point1 = myPolygon.get(i);
            Point2D.Double point2 = myPolygon.get(i+1); 
            myPencil.up();
            myPencil.move(point1.getX(), point1.getY());
            myPencil.down();
            myPencil.move(point2.getX(), point2.getY());
        }
        Point2D point0 = myPolygon.get(0);
        myPencil.move(point0.getX(), point0.getY());
    }

    public double distance(Point2D.Double p1, Point2D.Double p2)
    {
        // ((x2-x1)^2 +(y2-y1)^2)^1/2 
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y),2));
    }

    public double perimeter()
    {            
        double perimeter = 0;

        for (int i=0; i < myPolygon.size() -1; i++)
        {
            perimeter += distance(myPolygon.get(i), myPolygon.get(i + 1)); 
            //perimeter = perimeter+ distance from next 2 point
        }     
        perimeter += distance(myPolygon.get(myPolygon.size() - 1), myPolygon.get(0));
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
        for (int i=0; i < myPolygon.size() -1; i++)
        {
            area += myPolygon.get(i).x * myPolygon.get(i + 1).y;
        }
        area += myPolygon.get(myPolygon.size() - 1).x * myPolygon.get(0).y;        
        
        //(-y0x1 - y1x2 - y2x3 - ... yn-1 x0))
        for (int i=0; i < myPolygon.size() -1; i++)
        {
            area -= myPolygon.get(i).y * myPolygon.get(i + 1).x;
        }
        area -= myPolygon.get(myPolygon.size() - 1).y * myPolygon.get(0).x;     

        area = Math.abs(area / 2); //the 1/2 in front
        return area;        
    }

}