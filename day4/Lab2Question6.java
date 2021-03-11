package day4;

class StaticBlockClass{
	static {
		System.out.println("In static block");
	}
	
	public StaticBlockClass() {
		System.out.println("In constructor");
	}
}

public class Lab2Question6 {
	public static void main(String[] args) {
		StaticBlockClass obj = new StaticBlockClass();
	}
}
