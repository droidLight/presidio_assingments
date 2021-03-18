package day9;

public class CalculateAreaAndVolume {
	public static void main(String[] args) {
		
		Shape2D circle = new Circle(20);
		System.out.println(circle.calculateArea());
		
		Shape3D sphere = new Sphere(20);
		System.out.println(sphere.calculateArea());
		System.out.println(sphere.calculateVolume());
	}
}

class Circle extends Shape2D {
	private double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}

}

class Square extends Shape2D {
	private double side;

	Square(double side) {
		this.side = side;
	}

	@Override
	public double calculateArea() {
		return Math.pow(this.side, 2);
	}

}

class Triangle extends Shape2D {
	private double a, b, c;

	Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double calculateArea() {
		double s = (this.a + this.b + this.c) / 2;
		return Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
	}
}

class Sphere extends Shape3D {
	private double radius;

	Sphere(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(this.radius, 2) * 4;
	}

	@Override
	public double calculateVolume() {
		return Math.PI * Math.pow(this.radius, 3) * (4 / 3);
	}

}

class Cuboid extends Shape3D {
	private double side;

	Cuboid(double side) {
		this.side = side;
	}

	@Override
	public double calculateArea() {
		return Math.pow(this.side, 2) * 6;
	}

	@Override
	public double calculateVolume() {
		return Math.pow(this.side, 3);
	}

}

abstract class Shape {
}

abstract class Shape2D extends Shape implements CalculateArea {
}

abstract class Shape3D implements CalculateArea, CalculateVolume {
}

interface CalculateArea {
	double calculateArea();
}

interface CalculateVolume {
	double calculateVolume();
}
