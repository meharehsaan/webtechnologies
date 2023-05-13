import java.util.Scanner;

abstract class Shape {
     abstract double getArea();
    // public abstract String toString();
}

abstract class TwoDimensionalShape extends Shape {
}

abstract class ThreeDimensionalShape extends Shape {
    abstract double getVolume();
}

class Circle extends TwoDimensionalShape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }
}

class Square extends TwoDimensionalShape {
    private double sideLength;

    Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        return "Square with side length " + sideLength;
    }
}

class Triangle extends TwoDimensionalShape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle with base " + base + " and height " + height;
    }
}

class Sphere extends ThreeDimensionalShape {
    private double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    double getVolume() {
        return 4 * Math.PI * radius * radius * radius / 3;
    }

    @Override
    public String toString() {
        return "Sphere with radius " + radius;
    }
}

class Cube extends ThreeDimensionalShape {
    private double sideLength;

    Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    double getArea() {
        return 6 * sideLength * sideLength;
    }

    @Override
    double getVolume() {
        return sideLength * sideLength * sideLength;
    }

    @Override
    public String toString() {
        return "Cube with side length " + sideLength;
    }
}

class Tetrahedron extends ThreeDimensionalShape {
    private double sideLength;

    Tetrahedron(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    double getArea() {
        return Math.sqrt(3) * sideLength * sideLength;
    }

    @Override
    double getVolume() {
        return sideLength * sideLength * sideLength / (6 * Math.sqrt(2));
    }

    @Override
    public String toString() {
        return "Tetrahedron with side length " + sideLength;
    }
}

public class Shapes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // create an array of Shape references to objects of each concrete class in the hierarchy
        Shape[] shapes = new Shape[6];

        // fill the array with objects of each concrete class
        System.out.println("get radius for the circle: ");
        shapes[0] = new Circle(sc.nextDouble());

        System.out.println("get side length for the square: ");
        shapes[1] = new Square(sc.nextDouble());

         System.out.println("get the basse and hieght for the traiangle: ");
        shapes[2] = new Triangle(sc.nextDouble(), sc.nextDouble());

        System.out.println("get the radius for the sphere: ");
        shapes[3] = new Sphere(sc.nextDouble());

       System.out.println("Get the side lenght for the cube: ");
        shapes[4] = new Cube(sc.nextDouble());

        System.out.println("gget the side length for the tetrahedron:  ");
        shapes[5] = new Tetrahedron(sc.nextDouble());

	  // print the description of each shape and its area/volume
for (int i = 0; i < shapes.length; i++) {
    System.out.println(shapes[i]);
    if (shapes[i] instanceof TwoDimensionalShape) {
        TwoDimensionalShape shape2D = (TwoDimensionalShape) shapes[i];
        System.out.printf("Area: %.2f%n", shape2D.getArea());

    } else if (shapes[i] instanceof ThreeDimensionalShape) {
        ThreeDimensionalShape shape3D = (ThreeDimensionalShape) shapes[i];
        System.out.printf("Surface Area: %.2f%n", shape3D.getArea());
        System.out.printf("Volume: %.2f%n", shape3D.getVolume());
    }
}
    }
}
