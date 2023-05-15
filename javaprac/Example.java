import java.util.Scanner;
import java.io.*;

/*
This code includes:

Casting: converting a double to an int using casting
Wrapper classes: converting an Integer object to an int
Input/output: reading user input with Scanner and printing output to console
Inheritance: creating instances of Circle and Rectangle that inherit from Shape
Interfaces: creating an instance of Message that implements Printable
Exceptions: handling an ArrayIndexOutOfBoundsException with a try-catch block
Abstraction: defining an abstract Shape class and providing concrete implementations in Circle and Rectangle
Polymorphism: calling the getArea() method on both a Circle and a Rectangle instance, which have different implementations of the method.

*/

// abstract class
abstract class Shape {
    public abstract double getArea();
}

// concrete class extending Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

// concrete class extending Shape
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

// interface
interface Printable {
    void print();
}

// class implementing Printable interface
class Message implements Printable {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public void print() {
        System.out.println(message);
    }
}

public class Example {
    public static void main(String[] args) {
        // casting example
        double d = 3.14;
        int i = (int) d; // cast double to int
        System.out.println(i); // output: 3
        
        // wrapper class example
        Integer x = 5; // create Integer object
        int y = x.intValue(); // convert Integer object to int
        System.out.println(y); // output: 5
        
        // input/output example
        Scanner sc = new Scanner(System.in); // create Scanner object
        System.out.println("Enter your name: ");
        String name = sc.nextLine(); // read user input
        System.out.println("Hello, " + name + "!");
        
        // inheritance example
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Area of circle: " + circle.getArea());
        System.out.println("Area of rectangle: " + rectangle.getArea());
        
        // interface example
        Message message = new Message("Hello, world!");
        message.print();
        
        // exception example
        try {
            int[] arr = new int[5];
            arr[6] = 10; // causes ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
