package day4;

class QuadraticEquation {
	private int a, b, c;

	QuadraticEquation() {
		this.a = 1;
		this.b = 1;
		this.c = 1;
	}

	QuadraticEquation(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void updateCoeff(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getCoeffA() {
		return this.a;
	}

	public int getCoeffB() {
		return this.b;
	}

	public int getCoeffC() {
		return this.c;
	}
	
	public int compute(int x) {
		return this.a * x *x + this.b * x + this.c;
	}
}

public class Question24 {
	public static void main(String[] args) {
		QuadraticEquation eq = new QuadraticEquation();
		System.out.println("A: " + eq.getCoeffA() + " B: " + eq.getCoeffB() + " C: " + eq.getCoeffC()+" f(2): "+eq.compute(2));
		eq.updateCoeff(10, 14, 100);
		System.out.println("A: " + eq.getCoeffA() + " B: " + eq.getCoeffB() + " C: " + eq.getCoeffC()+" f(2): "+eq.compute(2));
	}
}
