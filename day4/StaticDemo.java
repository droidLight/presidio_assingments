package day4;

class AnotherClass{
	static int i;
	static {
		System.out.println("static block");
		i = 90;
	}
	static void amethod() {
		System.out.println("amethod called. "+i);
	}
}

public class StaticDemo {
	
	static void someMethod() {
		System.out.println("someMethod Called.");
	}
	
	public static void main(String[] args) {
		//StaticDemo obj = new StaticDemo();
		AnotherClass.amethod();
		System.out.println(AnotherClass.i);
		someMethod();
	}
}
