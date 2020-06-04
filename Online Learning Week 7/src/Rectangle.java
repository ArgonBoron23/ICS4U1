public class Rectangle implements Shape {

    // Constructor
    Rectangle(double length, double width) {

        this.side1 = length;
        this.side2 = width;
        
    }

    private double side1, side2;

    // Uses length * width formular to get area
    public double getArea() {

        return side1 * side2;

    }

    // Adds sides to get perimeter
    public double getPerimeter() {

        return 2 * (side1 + side2);

    }

}