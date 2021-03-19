package day10;

public class FoodExampleInPrototype {
	
	public static void main(String[] args) throws Exception{
		
		Rice rice = Rice.getInstance();
		rice.addItem(Dall.getInstance()).addItem(Chicken.getInstance());
		System.out.println(rice.getCost());
		
		ChickenBriyani chickenBriyani = ChickenBriyani.getInstance();
		chickenBriyani.addItem(Dall.getInstance()).addItem(Chicken.getInstance()).addItem(Rice.getInstance());
		System.out.println(chickenBriyani.getCost());
	}
}

abstract class Food {
	abstract int getCost();
	abstract Food addItem(Food food);
}

abstract class VegFood extends Food{}
abstract class NonVegFood extends Food{}


class Rice extends VegFood implements Cloneable{
	Food food;
	private static Rice instance;
	
	private Rice(){
		System.out.println("Rice Constructor called");
	}
	public static Rice getInstance() throws Exception{
		if(instance == null)
			instance = new Rice();
		return instance.createClone();
	}
	
	private Rice createClone() throws Exception{
		return (Rice) super.clone();
	}
	@Override
	public Food addItem(Food food) {
		this.food = food;
		return this;
	}
	
	@Override
	int getCost() {
		return 10 + ((this.food == null)? 0 : this.food.getCost());
	}
	
}

class Dall extends VegFood implements Cloneable{
	Food food;
	private static Dall instance;
	
	private Dall(){
		System.out.println("Dall Constructor called");
	}
	
	public static Dall getInstance() throws Exception{
		if(instance == null)
			instance = new Dall();
		return instance.createClone();
	}
	
	private Dall createClone() throws Exception{
		return (Dall) super.clone();
	}
	
	@Override
	public Food addItem(Food food) {
		this.food = food;
		return this;
	}
	
	@Override
	int getCost() {
		return 5 + ((this.food == null)? 0 : this.food.getCost());
	}
	
}

class ChickenBriyani extends NonVegFood implements Cloneable{
	Food food;
	private static ChickenBriyani instance;
	
	private ChickenBriyani(){
		System.out.println("ChickenBriyani Constructor called");
	}
	public static ChickenBriyani getInstance() throws Exception{
		if(instance == null)
			instance = new ChickenBriyani();
		return instance.createClone();
	}
	
	private ChickenBriyani createClone() throws Exception{
		return (ChickenBriyani) super.clone();
	}
	
	@Override
	public Food addItem(Food food) {
		this.food = food;
		return this;
	}
	
	@Override
	int getCost() {
		return 40 + ((this.food == null)? 0 : this.food.getCost());
	}
	
}

class Chicken extends NonVegFood implements Cloneable{
	Food food;
	private static Chicken instance;
	
	private Chicken(){
		System.out.println("Chicken Constructor called");
	}
	public static Chicken getInstance() throws Exception{
		if(instance == null)
			instance = new Chicken();
		return instance.createClone();
	}
	
	private Chicken createClone() throws Exception{
		return (Chicken) super.clone();
	}
	
	@Override
	public Food addItem(Food food) {
		this.food = food;
		return this;
	}
	
	@Override
	int getCost() {
		return 15 + ((this.food == null)? 0 : this.food.getCost());
	}
	
}