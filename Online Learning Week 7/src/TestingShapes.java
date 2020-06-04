import java.text.DecimalFormat;

public class TestingShapes {

    public static void main(String[] args) {

        // Creates new array of Shape objects
        Shape[] shapes = new Shape[4];

        // Decimal format to a certain amount of decimal places
        DecimalFormat df = new DecimalFormat("#.00");

        // Constructs new shape objects extending four different classes
        shapes[0] = new Rectangle(5.4, 2.6);
        shapes[1] = new Circle(10.6);
        shapes[2] = new Triangle(9.4, 9.8, 13.8);
        shapes[3] = new Trapezoid(5.6, 2.2, 2.1, 3.4, 2);

        // Output statements
        // Rectangle should be A = 14.04 and P = 16.00
        System.out.println("\nThe rectangles's area is " + df.format(shapes[0].getArea())
                + " squared units and its perimeter is " + df.format(shapes[0].getPerimeter()) + " units");
        // Circle should be A = 352.99 and P = 66.60
        System.out.println("The circle's area is " + df.format(shapes[1].getArea())
                + " squared units and its perimeter is " + df.format(shapes[1].getPerimeter()) + " units");
        // Triangle should be A = 46.04 and P = 33.00
        System.out.println("The triangle's area is " + df.format(shapes[2].getArea())
                + " squared units and its perimeter is " + df.format(shapes[2].getPerimeter()) + " units");
        // Trapezoid should be A = 7.80 and P = 13.3
        System.out.println("The trapezoid's area is " + df.format(shapes[3].getArea())
                + " squared units and its perimeter is " + df.format(shapes[3].getPerimeter()) + " units");
    }
}