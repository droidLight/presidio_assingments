package day5;
import java.lang.*;

public class Lab2Equation {
	
	static double area(double radius, double height) {
		return Math.PI * Math.pow(radius, 2) + 2 * Math.PI * radius * height;  
	}
	
	static double calcEnergy(double mass, double height, double acceleration, double velocity) {
		return mass * (acceleration * height + Math.pow(velocity, 2) / 2);
	}
	public static void main(String[] args) {
		
		System.out.println("Area: "+area(10, 14));
		System.out.println("Energy: "+calcEnergy(5, 45, 9.8, 20));
	}
}
