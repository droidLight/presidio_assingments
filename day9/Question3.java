package day9;

public class Question3 {

	public static void main(String[] args) {
		
		NewClass obj = new NewClass();
		NewNewClass newObj = new NewNewClass();
		
		testMethodOne(obj);
		testMethodTwo(obj);
		testMethodThree(obj);
		testMethodFour(obj);
		System.out.println("\n");
		testMethodOne(newObj);
		testMethodTwo(newObj);
		testMethodThree(newObj);
		testMethodFour(newObj);		
	}

	private static void testMethodOne(InterfaceOne var) {
		var.interfaceOneMethodOne();
		var.interfaceOneMethodTwo();
		var.interfaceOneMethodThree();
	}

	private static void testMethodTwo(InterfaceTwo var) {
		var.interfaceTwoMethodOne();
		var.interfaceTwoMethodTwo();
		var.interfaceTwoMethodThree();
	}

	private static void testMethodThree(InterfaceThree var) {
		var.interfaceThreeMethodOne();
		var.interfaceThreeMethodTwo();
		var.interfaceThreeMethodThree();
	}

	private static void testMethodFour(NewInterface var) {
		var.newMethod();
		
		var.interfaceOneMethodOne();
		var.interfaceOneMethodTwo();
		var.interfaceOneMethodThree();
		
		var.interfaceTwoMethodOne();		
		var.interfaceTwoMethodTwo();
		var.interfaceTwoMethodThree();
		
		var.interfaceThreeMethodOne();
		var.interfaceThreeMethodTwo();
		var.interfaceThreeMethodThree();			
	}
}

interface InterfaceOne {
	void interfaceOneMethodOne();

	void interfaceOneMethodTwo();

	void interfaceOneMethodThree();
}

interface InterfaceTwo {
	void interfaceTwoMethodOne();

	void interfaceTwoMethodTwo();

	void interfaceTwoMethodThree();
}

interface InterfaceThree {
	void interfaceThreeMethodOne();

	void interfaceThreeMethodTwo();

	void interfaceThreeMethodThree();
}

interface NewInterface extends InterfaceOne, InterfaceTwo, InterfaceThree {
	void newMethod();
}

class NewClass implements NewInterface {

	@Override
	public void interfaceOneMethodOne() {
		System.out.println("interfaceOneMethodOne");

	}

	@Override
	public void interfaceOneMethodTwo() {
		System.out.println("interfaceOneMethodTwo");

	}

	@Override
	public void interfaceOneMethodThree() {
		System.out.println("interfaceOneMethodThree");

	}

	@Override
	public void interfaceTwoMethodOne() {
		System.out.println("interfaceTwoMethodOne");

	}

	@Override
	public void interfaceTwoMethodTwo() {
		System.out.println("interfaceTwoMethodTwo");

	}

	@Override
	public void interfaceTwoMethodThree() {
		System.out.println("interfaceTwoMethodThree");

	}

	@Override
	public void interfaceThreeMethodOne() {
		System.out.println("interfaceThreeMethodOne");

	}

	@Override
	public void interfaceThreeMethodTwo() {
		System.out.println("interfaceThreeMethodTwo");

	}

	@Override
	public void interfaceThreeMethodThree() {
		System.out.println("interfaceThreeMethodThree");

	}

	@Override
	public void newMethod() {
		// TODO Auto-generated method stub

	}

}
class NewNewClass extends NewClass{}