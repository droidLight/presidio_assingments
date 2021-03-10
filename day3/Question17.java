package day3;

class Base {
}

class Sub extends Base {
}

class Sub2 extends Base {
}

public class Question17 {
	public static void main(String args[]) {

		Base b = new Base();
		Sub s = (Sub) b;
	}// Base class cannot be casted to Sub class
}
