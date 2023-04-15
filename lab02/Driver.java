import java.util.*;

// Abstract TwoDimensionalShape class
abstract class TwoDimensionalShape{
	abstract double getArea(); 
}

//Circle class overriding functions
class Circle extends TwoDimensionalShape {
	private double radius;

	Circle(double radius) {
        	this.radius = radius;
    	}

	@Override
	public double getArea(){
		return Math.PI*radius*radius;
	} 

	@Override
    	public String toString() {
        	return "Circle with radius";
    	}
}

//Square class overriding functions
class Square extends TwoDimensionalShape {
	private double sidelength;

	Square (double sidelength) {
        	this.sidelength = sidelength;
    	}

	@Override
	public double getArea(){
		return sidelength*sidelength;
	}	

	@Override
    	public String toString() {
        	return "Square with sidelength";
    	}
}

//Triangle class overriding functions
class Triangle extends TwoDimensionalShape {
	private double base;
	private double height;

	Triangle(double base, double height) {
        this.height = height;
	this.base = base;
    	}

	@Override
	public double getArea(){
		return (0.5)*(base*height);
	}

	@Override
    	public String toString() {
        	return "Triangle with base & height";
    	}
}



public class Driver{
	public static void main(String[] args){
		TwoDimensionalShape[] arr = new TwoDimensionalShape[3];
        	Scanner in = new Scanner(System.in);
		
		
		System.out.println("Enter Radius");
		arr[0] = new Circle(in.nextDouble());
		
		System.out.println("Enter sidelength");
		arr[1] = new Square(in.nextDouble());

		System.out.println("Enter base & length");
		double base = in.nextDouble();
		double length = in.nextDouble();
		arr[2] = new Triangle(base, length);

		
		Triangle obj1 = new Triangle(base, length);
		System.out.println(obj1.getArea());

		for(int i = 0; i < arr.length; i++){
			if(arr[i] instanceof TwoDimensionalShape){
				TwoDimensionalShape obj = (TwoDimensionalShape) arr[i];
				System.out.println("Area of becomes : " + obj.getArea());
			}
		}

	}

}
