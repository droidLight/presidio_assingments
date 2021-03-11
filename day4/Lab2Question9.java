package day4;

class A {
	private int a;
	protected int b;
	public int c;

	private void amethod() {
	}

	protected void bmethod() {
	}

	public void cmethod() {
	}
}

class B extends A {
	
	public B() {
		this.bmethod();
		this.cmethod();
		this.b = 10;
		this.c = 19;
	}
}

public class Lab2Question9 {
	public static void main(String[] args) {

	}
}
