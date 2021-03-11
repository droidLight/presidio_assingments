package day4;

class House {
	Door door;
	Window window;
	int otherCost, windowSize, doorSize;

	public House(int windowSize, int doorSize) {
		this.door = new Door();
		this.window = new Window();
		this.windowSize = windowSize;
		this.doorSize = doorSize;
	}

	int getTotalCost() {
		return this.otherCost + this.door.getCost(this.doorSize) + this.window.getCost(this.windowSize);
	}
}

class Door {
	int getCost(int area) {
		return 10 * area;
	}
}

class Window {
	int getCost(int area) {
		return 10 * area;
	}
}

public class Lab2Question15 {
	public static void main(String[] args) {
		House house = new House(100, 5);
		System.out.println("TotalCost: "+house.getTotalCost());
	}
}
