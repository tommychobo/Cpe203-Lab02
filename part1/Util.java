public class Util {
    public static double perimeter(Circle c){
        return 2.0*Math.PI*c.getRadius();
    }
    public static double perimeter(Rectangle r){
        double width = Math.abs(r.getBottomRight().getX() - r.getTopLeft().getX());
        double height = Math.abs(r.getBottomRight().getY() - r.getTopLeft().getY());
        return 2*width + 2*height;
    }
    public static double perimeter(Polygon p){
        double lengthSum = 0.0;
        for(int i = 1; i < p.getPoints().size(); i++){
            lengthSum += pythagoras(p.getPoints().get(i), p.getPoints().get(i-1));
        }
        lengthSum += pythagoras(p.getPoints().get(0), p.getPoints().get(p.getPoints().size()));
        return lengthSum;
    }
    private static double pythagoras(Point p1, Point p2){
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }
}
