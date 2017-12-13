import java.awt.geom.*;
public interface Polygon{
   public void add(Point2D.Double aPoint);
   public void draw();
   public double perimeter();
   public double area();
   public String getName();
}