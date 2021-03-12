package day5;

interface TestInterface{
	void displayInteger(int x);
}

class TestClass implements TestInterface{
	
	@Override
	public void displayInteger(int x) {
		System.out.println("displayInteger: "+x);		
	}
	
}

public class Lab6InterfaceImplementation {

	public static void main(String[] args) {
		TestInterface obj = new TestClass();
		obj.displayInteger(10);
	}
}
