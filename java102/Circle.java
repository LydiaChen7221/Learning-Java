package java102;

public class Circle implements Shape {
	public final Point center;
	public final double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	/** 
	* @return Whether point p is inside of the circle.
	*/
	public boolean isInside(Point p) {
		return Point.distance(center, p) < radius;
	}

	/** 
	* @return Whether point p part of/on the border of the circle.
	*/
	public boolean isOn(Point p) {
		return Point.distance(center, p) == radius;
	}

	/** 
	* @param x How much to translate the circle by in the + x direction.
	* @param y How much to translate the circle by in the + y direction.
	* @return The circle that results from the translation.
	*/
	public Circle translate(double x, double y) {
		return new Circle(center.translateX(x).translateY(y), radius);
	}

	/** 
	* @return The circle that results from scaling by k.
	*/
	public Circle scale(double k) {
		return new Circle(center, radius * k);
	}

	@Override
	public String toString() {
		return "(center: " + center + "; radius: " + radius + ")";
	}

    //Practice Problem 5 - fromPoints:
    public static Circle fromPoints(Point p1, Point p2, Point p3){
        double x1 = p1.x;
		double y1 = p1.y;
		double x2 = p2.x;
		double y2 = p2.y;
		double x3 = p3.x;
		double y3 = p3.y;

		double D = 2 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

		double centerX = ((x1 * x1 + y1 * y1) * (y2 - y3) +
						 (x2 * x2 + y2 * y2) * (y3 - y1) +
						 (x3 * x3 + y3 * y3) * (y1 - y2)) / D;

		double centerY = ((x1 * x1 + y1 * y1) * (x3 - x2) +
						 (x2 * x2 + y2 * y2) * (x1 - x3) +
						 (x3 * x3 + y3 * y3) * (x2 - x1)) / D;

		Point center = new Point(centerX, centerY);
		double radius = Point.distance(center, p1);
		return new Circle(center, radius);
    }
}