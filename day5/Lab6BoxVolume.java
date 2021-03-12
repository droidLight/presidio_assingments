package day5;

class Box {
	int height, length, breadth;

	Box(int x) {
		this.length = x;
		this.height = x;
		this.breadth = x;
	}

	Box(int length, int height, int breadth) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	int calculateVolume() {
		return this.length * this.breadth * this.height;
	}
}

public class Lab6BoxVolume {
	public static void main(String[] args) {
		
		Box cube = new Box(4);
		Box cuboid = new Box(4, 5, 6);

		System.out.println("Volume of cube: "+cube.calculateVolume());
		System.out.println("Volume of cuboid: "+cuboid.calculateVolume());
	}
}
