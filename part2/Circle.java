public class Circle {
    private Point center;
    private double radius;
    public Circle(Point p, double r){
        center = p;
        radius = r;
    }
    public double perimeter(){
        return 2.0*Math.PI*radius;
    }
    public Point getCenter(){
        return center;
    }
    public double getRadius(){
        return radius;
    }
}
