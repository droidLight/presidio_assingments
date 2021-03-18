package day8;

public class DecoratorDemo {
	public static void main(String[] args) {
		
		Food food = new Rice(new VegCurry(new ChickenCurry()));
		System.out.println("Total cost: "+food.getCost());
	}
}

abstract class Food{
	abstract int getCost();
}

abstract class VegFood extends Food{}
abstract class NonVegFood extends Food{}

class Rice extends VegFood{
	Food food;
	
	Rice(){}
	Rice(Food food){
		//static composition
		this.food = food;
	}
	@Override
	int getCost() {
		return (food == null)? 10 : 10 + this.food.getCost(); 
	}	
}

class VegCurry extends VegFood{
	Food food;
	
	VegCurry(){}
	VegCurry(Food food){
		//static composition
		this.food = food;
	}
	@Override
	int getCost() {
		return (food == null)? 10 : 10 + this.food.getCost(); 
	}
	
}

class ChickenCurry extends NonVegFood{
	Food food;
	
	ChickenCurry(){}
	ChickenCurry(Food food){
		//static composition
		this.food = food;
	}
	@Override
	int getCost() {
		return (food == null)? 25 : 25 + this.food.getCost(); 
	}
	
}