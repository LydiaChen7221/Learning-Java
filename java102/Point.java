package java102;

public class Point {
    public final double x;
    public final double y;
    public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }
    public Point translateX(double t) {
        return new Point(x+t, y);
    }
    public Point translateY(double t) {
        return new Point (x, y+t);
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y,2));
    }

    //Getters used for Practice Problem 1:
    public double retrieveX(){
        return x;
    }
    public double retrieveY(){
        return y;
    }
    //Practice Problem 1 - Center Of Mass:
    public static Point centerOfMass(Point[] points) {
        double totalX=0.0;
        double totalY=0.0;
        for(Point center:points){
            totalX+=center.retrieveX();
            totalY+=center.retrieveY();
        }
        double avgX = totalX/points.length;
        double avgY = totalY/points.length;
        return new Point(avgX, avgY);
    }

    //Practice Problem 2 - Finding Angle:
    public double angle(){
        double radians=Math.atan2(y, x);
        double degrees=Math.toDegrees(radians);
        return degrees;
    }
}
