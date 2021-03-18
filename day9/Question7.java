package day9;
import day9.vehicle.FourWheeler;

public class Question7 {
	public static void main(String[] args) {
		Car car = new Car();
		car.startCar();
	}
}


class Car extends FourWheeler{

	@Override
	protected void start() {
		System.out.println("vehicle started");		
	}
	
	public void startCar() {
		this.start();
	}
}