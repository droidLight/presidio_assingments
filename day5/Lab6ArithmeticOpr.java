package day5;

public class Lab6ArithmeticOpr {

	static double operator(int x) {
		return Math.pow(x, 2);
	} 
	
	static int operator(int x, int y) {
		return x + y;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Single parameter: "+operator(10));
		System.out.println("Double parameter: "+operator(10, 20));
	}
}
