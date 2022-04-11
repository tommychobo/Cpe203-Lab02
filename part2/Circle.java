public class Circle {
    private Point center;
    private double radius;
    public Circle(Point p, double r){
        center = p;
        radius = r;
    }
    public Point getCenter(){
        return center;
    }
    public double getRadius(){
        return radius;
    }
}
