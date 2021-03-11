package day4;

class AClass {
	public AClass() {
		System.out.println("A constructor");
	}
}

class BClass {
	public BClass() {
		System.out.println("B constructor");
	}
}

class CClass extends AClass {
	BClass b = new BClass();

}

public class Lab2Question10 {
	public static void main(String[] args) {
		CClass obj = new CClass();

	}
}
