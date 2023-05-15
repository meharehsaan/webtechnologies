import java.util.*;

abstract class Shape {
    public abstract double area();

    public static void main(String[] args) {
        
        Shape shape = new Circle(2.5);
        double area = shape.area(); // This calls the area() method defined in the Shape class
        System.out.println(area);
        Circle circle = (Circle) shape;
        double radius = circle.area(); // This calls the getRadius() method defined in the Circle class
        System.out.println(radius);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    public double area() {
        return Math.PI * radius * radius;
    }
}
