// import java.util.*;
import javax.swing.*;

public class geometric {
	public static void main(String[] args) {
		// Scanner in = new Scanner();

		double result;

		if (args[0].equals("square") && !(args.length < 2)) {
			result = square(Double.parseDouble(args[1]));
			JOptionPane.showMessageDialog(null, "Area becomes : " + result);
		} else if (args[0].equals("rectangle") && !(args.length < 3)) {
			result = rectangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
			JOptionPane.showMessageDialog(null, "Area becomes : " + result);
		} else if (args[0].equals("parallelogram") && !(args.length < 3)) {
			result = parallelogram(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
			JOptionPane.showMessageDialog(null, "Area becomes : " + result);
		} else if (args[0].equals("trapezoid") && !(args.length < 4)) {
			result = trapezoid(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
			JOptionPane.showMessageDialog(null, "Area becomes : " + result);
		} else if (args[0].equals("triangle") && !(args.length < 3)) {
			result = triangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
			JOptionPane.showMessageDialog(null, "Area becomes : " + result);
		} else if (args[0].equals("circle") && !(args.length < 2)) {
			result = circle(Double.parseDouble(args[1]));
			JOptionPane.showMessageDialog(null, "Area becomes : " + result);
		} else if (args[0].equals("ellipse") && !(args.length < 3)) {
			result = ellipse(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
			JOptionPane.showMessageDialog(null, "Area becomes : " + result);
		} else {
			System.out.println("Error, try again");
		}
	}

	public static double square(double s) {
		double val;
		val = s * s;
		return val;
	}

	public static double rectangle(double l, double w) {
		double val;
		val = l * w;
		return val;
	}

	public static double parallelogram(double b, double h) {
		double val;
		val = b * h;
		return val;
	}

	public static double trapezoid(double b1, double b2, double h) {
		double val;
		val = ((b1 + b2) / 2) * h;
		return val;
	}

	public static double triangle(double b, double h) {
		double val;
		val = (0.5) * b * h;
		return val;
	}

	public static double circle(double r) {
		double val;
		val = (22 / 7) * r;
		return val;
	}

	public static double ellipse(double a, double b) {
		double val;
		val = (22 / 7) * a * b;
		return val;
	}
}
