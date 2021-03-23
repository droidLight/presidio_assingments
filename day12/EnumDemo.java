package day12;

public class EnumDemo {
	public static void main(String[] args) {
		
		Cars[] cars = Cars.values();
		for(Cars car : cars) {
			System.out.println("Prize of "+car+" is "+car.getPrice()+" lakhs");
		}
		
		method(cars[3]);
	}
	
	static void method(Cars car) {
		switch(car) {
		case swift:
			System.out.println("It is swift");
			break;
		case tigor:
			System.out.println("It is tigor");
			break;
		case kwid:
			System.out.println("it is kwid");
			break;
		case thar:
			System.out.println("It is thar");
			break;
		default:
			System.out.println("Some other car");
		}
	}
}

enum Cars{
	swift(4), tigor(3), kwid(3), thar(6);
	
	int price;
	Cars(int price){
		this.price = price;
	}
	
	int getPrice() {
		return this.price;
	}
}