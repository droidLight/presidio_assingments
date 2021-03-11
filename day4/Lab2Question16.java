package day4;

class X {
	void do1() {
		System.out.println("x");
	}
}

class Y extends X {
	void do2() {
		System.out.println("y");
	}
}

public class Lab2Question16 {
	public static void main(String[] args) {
		X x1 = new X(); 
		X x2 = new Y(); 
		Y y1 = new Y(); 
		y1.do2();
	}
}
