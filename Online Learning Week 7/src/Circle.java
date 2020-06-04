public class Circle implements Shape {

    // Constructor
    Circle(double radius) {

        this.radius = radius;
        
    }

    //Declares member variable
    private double radius;

    // Uses area formula to get area
    public double getArea() {

        return Math.PI * Math.pow(radius, 2);

    }

    // Adds sides to get perimeter
    public double getPerimeter() {

        return Math.PI * radius * 2;

    }

}