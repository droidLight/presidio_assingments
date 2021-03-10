package day3;

public class Question2 {
	
	public static void main(String arguments[]) {
		amethod(arguments);
	}
	
	public void amethod(String[] arguments) {
		System.out.println(arguments);
		System.out.println(arguments[1]);
	}
	
	//answer: Cannot access non-static method from static method. (option 1)
}
