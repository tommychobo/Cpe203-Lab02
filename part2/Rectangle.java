public class Rectangle {
    private Point topLeft;
    private Point bottomRight;
    public Rectangle(Point tl, Point br){
        topLeft = tl;
        bottomRight = br;
    }

    public Point getTopLeft(){
        return topLeft;
    }
    public Point getBottomRight() {
        return bottomRight;
    }
}
