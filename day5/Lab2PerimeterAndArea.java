package day5;

import java.util.Scanner;

public class Lab2PerimeterAndArea {

	static double getArea(double length, double breadth) {
		return length * breadth;
	}

	static double getArea(double length) {
		return Math.pow(length, 2);
	}

	static double getPerimeter(double length, double breadth) {
		return 2 * (length + breadth);
	}

	static double getPerimeter(double length) {
		return 4 * length;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter length of side of square: ");
		double lengthSq = s.nextDouble();
		System.out.println("Square area: "+ getArea(lengthSq));
		System.out.println("Square perimeter: "+ getPerimeter(lengthSq));
		
		
		System.out.println("Enter length of side of rectangle: ");
		double lengthRect = s.nextDouble();
		System.out.println("Enter breadth of side of rectangle: ");
		double breadthRect = s.nextDouble();
		System.out.println("Rectangle area: "+getArea(lengthRect, breadthRect));
		System.out.println("Rectangle perimeter: "+getPerimeter(lengthRect, breadthRect));
		
	}
}
