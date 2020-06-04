public class Trapezoid implements Shape {

    // Constructor (baseA and baseB are parallel sides, sideA and sideB are
    // connecting sides, height is perpendicular distance between bases)
    Trapezoid(double baseA, double baseB, double sideA, double sideB, double height) {

        this.base1 = baseA;
        this.base2 = baseB;
        this.side1 = sideA;
        this.side2 = sideB;
        this.height = height;

    }

    // Declares member variables
    private double base1, base2, side1, side2, height;

    // Uses trapezoid area formula to get area
    public double getArea() {

        return (base1 + base2) / 2 * height;

    }

    // Adds sides to get perimeter
    public double getPerimeter() {

        return base1 + base2 + side1 + side2;

    }

}