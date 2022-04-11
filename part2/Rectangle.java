public class Rectangle {
    private Point topLeft;
    private Point bottomRight;
    public Rectangle(Point tl, Point br){
        topLeft = tl;
        bottomRight = br;
    }

    public double perimeter(){
        double width = Math.abs(bottomRight.getX() - topLeft.getX());
        double height = Math.abs(bottomRight.getY() - topLeft.getY());
        return 2*width + 2*height;
    }
    public Point getTopLeft(){
        return topLeft;
    }
    public Point getBottomRight() {
        return bottomRight;
    }
}
