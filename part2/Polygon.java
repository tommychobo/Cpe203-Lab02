import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private List<Point> points;
    public double perimeter(){
        double lengthSum = 0.0;
        for(int i = 1; i < points.size(); i++){
            lengthSum += pythagoras(points.get(i), points.get(i-1));
        }
        lengthSum += pythagoras(points.get(0), points.get(points.size()-1));
        return lengthSum;
    }
    private static double pythagoras(Point p1, Point p2){
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }
    public Polygon(ArrayList<Point> pts){
        points = pts;
    }
    public List<Point> getPoints(){
        return points;
    }
}
