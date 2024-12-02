package java102;

public class Square implements Shape {
	public final Point corner;
	public final double sideLength;

	/**
	* @param corner The bottom left corner of the square
	* @param sideLength
	*/
	public Square(Point corner, double sideLength) {
		this.corner = corner;
		this.sideLength = sideLength;
	}

	public double area() {
		return Math.pow(sideLength, 2);
	}
	
	public double perimeter() {
		return 4 * sideLength;
	}
	
	/** 
	* @return Whether point p is inside of the square.
	*/
	public boolean isInside(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
		return (0 < xDist && xDist < sideLength) &&
			    (0 < yDist && yDist < sideLength);
	}

	/** 
	* @return Whether point p part of/on the border of the square.
	*/
	public boolean isOn(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
        return ((0 <= xDist && xDist <= sideLength) &&
                (0 <= yDist && yDist <= sideLength)) && 
                ((xDist == 0 || xDist == sideLength) ||
                (yDist == 0 || yDist == sideLength));
	}
	
	/** 
	* @param x How much to translate the square by in the + x direction.
	* @param y How much to translate the square by in the + y direction.
	* @return The square that results from the translation.
	*/
	public Square translate(double x, double y) {
		return new Square(corner.translateX(x).translateY(y), sideLength);
	}

	/** 
	* @return The square that results from scaling the side length and maintaining the bottom left corner
	*/
	public Square scale(double k) {
		return new Square(corner, sideLength * k);
	}

	public Point[] corners() {
		Point[] cornerPoints = new Point[4];
        cornerPoints[0] = new Point(corner.x, corner.y);
        cornerPoints[1] = new Point(corner.x+sideLength, corner.y);
        cornerPoints[2] = new Point(corner.x, corner.y+sideLength);
        cornerPoints[3] = new Point(corner.x+sideLength, corner.y+sideLength);
        return cornerPoints;
	}

	@Override
	public String toString() {
		return "(corner: " + corner + "; side length: " + sideLength + ")";
	}
}