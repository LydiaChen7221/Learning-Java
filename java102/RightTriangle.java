package java102;

//Practice Problem 6 - RightTriangle Class implements Shape
public class RightTriangle implements Shape{
    public final Point corner;
	public final double adjacent;
    public final double opposite;
    
	/**
	* @param corner The bottom left corner of the right triangle, the right angle
	* @param adjacent The side of the right triangle parallel to the x-axis
	* @param opposite The side of the right triangle parallel to the y-axis
	*/
    public RightTriangle(Point corner, double adjacent, double opposite){
        this.corner = corner;
        this.adjacent = adjacent;
        this.opposite = opposite;
    }

    public double area() {
		return (adjacent * opposite) / 2;
	}
	
	public double perimeter() {
		return adjacent + opposite + 
				(Math.sqrt((Math.pow(adjacent, 2)) + 
				(Math.pow(opposite, 2))));
	}
	
	/** 
	* @return Whether point p is inside of the right triangle.
	*/
	public boolean isInside(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
		return ((0 < xDist && xDist < adjacent) &&
				(0 < yDist && yDist < opposite)) && 
				(yDist * adjacent < xDist * opposite);
	}

	/** 
	* @return Whether point p part of/on the border of the right triangle.
	*/
	public boolean isOn(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
        return ((0 <= xDist && xDist <= adjacent) &&
                (0 <= yDist && yDist <= opposite)) && 
                (yDist * adjacent == xDist * opposite);
	}
	
	/** 
	* @param x How much to translate the right triangle by in the + x direction.
	* @param y How much to translate the right triangle by in the + y direction.
	* @return The right triangle that results from the translation.
	*/
	public RightTriangle translate(double x, double y) {
		return new RightTriangle(corner.translateX(x).translateY(y), adjacent, opposite);
	}

	/** 
	* @return The right triangle that results from scaling the side length and maintaining the bottom left corner
	*/
	public RightTriangle scale(double k) {
		return new RightTriangle(corner, adjacent * k, opposite * k);
    }	

	@Override
	public String toString() {
		return "(corner: " + corner + "; adjacent side: " + adjacent 
		+ "; opposite side: " + opposite + ")";
	}

	public static boolean similar(RightTriangle a, RightTriangle b) {
		double hypotenuseA = (Math.sqrt(Math.pow(a.adjacent, 2)) + 
							(Math.pow(a.opposite, 2)));
		double hypotenuseB = (Math.sqrt(Math.pow(b.adjacent, 2)) + 
							(Math.pow(b.opposite, 2)));
		return (a.adjacent == b.adjacent) && 
				(a.opposite == b.opposite) &&
				(hypotenuseA == hypotenuseB);
	}
}
