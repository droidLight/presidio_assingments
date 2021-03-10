package day3;

class ParentClass {
	ParentClass(int i) {
		System.out.println("base constructor");
	}

	ParentClass() {
	}
}

public class Question40 extends ParentClass {
	public static void main(String argv[]) {
		Question40 obj = new Question40();
		// One
	}

	Question40() {
		// Two
		super(10);
	}

	public void derived() {
		// Three
	}
}
