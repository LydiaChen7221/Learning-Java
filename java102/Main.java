package java102;

import java.util.ArrayList;

public class Main {
    static <T> String arrayToString(T[] arr1) {
            String str = "[";
            for (int i = 0; i < arr1.length - 1; i++) {
                str += arr1[i] + ", ";
            }
            return str + arr1[arr1.length - 1] + "]";
    }

    //Shapes
    static double sumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }
    static Shape[] scaleAll(Shape[] shapes, double k) {
        Shape[] scaled = new Shape[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            scaled[i] = shapes[i].scale(k);
        }
        return scaled;
    }

    //Inheritance - Practice Problems
    public static void returnAll(LibraryItem[] items) {
        for(int i=0; i < items.length; i++) {
            items[i].returnItem();
        }
    }
    public static ArrayList<LibraryItem> availableItems(LibraryItem[] items) {
        ArrayList<LibraryItem> availableItems = new ArrayList<LibraryItem>();
        for(int i=0; i <items.length; i++) {
            if(items[i].available()){
                availableItems.add(items[i]);
            }
        }
        return availableItems;
    }
    
    public static void main(String[] args) {
        //Points
        Point point = new Point(4,3);  
        System.out.println("x: " + point.x + " y: " + point.y);
        Point xTranslation = point.translateX(3); 
        Point yTranslation = point.translateY(-7); 
        Point xyTranslation = point.translateX(-4).translateY(-3);
        System.out.println("x transl: " + xTranslation);
        System.out.println("y transl: " + yTranslation);
        System.out.println("xy transl: " + xyTranslation);
        System.out.println("point: " + point);
        Point pointA = new Point(8,6);
        Point pointB = new Point(5,7);
        System.out.println(Point.distance(pointA, pointB));
        Point[] points = {new Point(1,2), new Point(3,4), new Point(5,6)};
        Point center = Point.centerOfMass(points);
        //Points Practice Problems
        System.out.println("Center Of Mass:" + center);
        System.out.println("Angle: " + point.angle()+" degrees");

        //Generics + ArrayLists
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");
        System.out.println(arr);
        arr.set(0, "Goodbye");
        System.out.println(arr);
        ArrayList<Boolean> conditions = new ArrayList<>();
        conditions.add(true);
        conditions.add(arr.get(0) == "Hello");
        conditions.add(conditions.get(0) || conditions.get(1));
        System.out.println(conditions);
        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
	        intArr.add(0);
        }
        System.out.println(intArr.size());
        System.out.println(intArr.get(32));

        //Grids
        Grid<Integer> grid = new Grid<>(5, 0);
        grid.set(2, 2, 4);
        System.out.println(grid);
        System.out.println(grid.get(3, 2));
        //Grids Practice Problems
        System.out.println(grid.diagonal());
        System.out.println(Grid.maxSideLength());

        Point p = new Point(1, 1);
        //Circles
        Circle circle = new Circle(new Point(0, 0), 5.0);
        System.out.println(circle);
        System.out.println(circle.area());
        System.out.println(circle.perimeter());
        System.out.println(circle.isInside(p));
        System.out.println(circle.isOn(p));
        System.out.println(circle.translate(4.0, 2.0));
        System.out.println(circle.scale(3));

        //Squares
        Square square = new Square(new Point(0, 0), 5);
        System.out.println(square);
        System.out.println(square.area());
        System.out.println(square.perimeter());
        System.out.println(square.isInside(p));
        System.out.println(square.isOn(p));
        System.out.println(square.translate(5, 3));
        System.out.println(square.scale(2));
        System.out.println(Main.arrayToString(square.corners()));

        //Interface + Shapes
        Shape[] shapes = {new Circle(new Point(1.8, -20), 2), 
            new Square(new Point(100, 2.1), 5.4),
            new Circle(new Point(0, 0), 1),
            new Circle(new Point(4, 9.123), 98.32),
            new Square(new Point(-321, 0), 0.02)};
        System.out.println(sumArea(shapes));
        System.out.println(Main.arrayToString(scaleAll(shapes, 6)));
        //Shapes Practice Problems
        Point p1 = new Point(1, 1);
        Point p2 = new Point(4, 5);
        Point p3 = new Point(6, 1);
        System.out.println(Circle.fromPoints(p1, p2, p3));
        //Practice Problem - RightTriangle
        RightTriangle rightTriangle = new RightTriangle(new Point(0, 0), 5, 4);
        System.out.println(rightTriangle);
        System.out.println(rightTriangle.area());
        System.out.println(rightTriangle.perimeter());
        System.out.println(rightTriangle.isInside(p));
        System.out.println(rightTriangle.isOn(p));
        System.out.println(rightTriangle.translate(2, 3));
        System.out.println(rightTriangle.scale(4));
        RightTriangle triangleA = new RightTriangle(new Point(0, 0), 2, 7);
        RightTriangle triangleB = new RightTriangle(new Point(0, 0), 3, 7);
        System.out.println(RightTriangle.similar(triangleA, triangleB));

        //Inheritance
        A a = new A(12.3, 430);
        B b = new B(-12.31, "hello");
        a.method1();
        b.method1();
        b.method2();
        A bInDisguise = new B(1002.013, "world");
        bInDisguise.method2();
        LibraryItem[] items = {new DVD(null, null, 0),
                new Book(null, null, null, 0), 
                new Book(null, null, null, 0),
                new Book(null, null, null, 0),
                new DVD(null, null, 0)};
        items[1].checkOut();
        items[4].checkOut();
        System.out.println(Main.arrayToString(items));
        System.out.println(Main.availableItems(items));
        
    }
}
