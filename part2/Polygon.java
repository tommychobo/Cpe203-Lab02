import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private List<Point> points;
    public Polygon(ArrayList<Point> pts){
        points = pts;
    }
    public List<Point> getPoints(){
        return points;
    }
}
