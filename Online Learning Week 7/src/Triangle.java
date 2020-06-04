public class Triangle implements Shape {

    // Constructor
    Triangle(double sideA, double sideB, double sideC) {

        this.side1 = sideA;
        this.side2 = sideB;
        this.side3 = sideC;

    }

    private double side1, side2, side3;

    // Uses Heron's formula to get area
    public double getArea() {

        double p = this.getPerimeter() / 2; // half the perimeter
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

    }

    // Adds sides to get perimeter
    public double getPerimeter() {

        return side1 + side2 + side3;

    }

}