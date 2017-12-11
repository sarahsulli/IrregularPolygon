import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon{
   private ArrayList <Point2D.Double> myPolygon;
   private DrawingTool draw;

   // constructors
   public IrregularPolygon() 
   {
        myPolygon = new ArrayList<Point2D.Double>();    
   }

   // public methods
   public void add(Point2D.Double aPoint) 
   { 
    
   }

   public void draw() 
   { 
    
   }
   
   public double distance(Point2D.Double p1, Point2D.Double p2)
   {
       
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
        }        
   }

   public double area() 
   {
        if (myPolygon.size() < 3)
        {
            return 0;
        }
        //need 2 loops bec
   }
}