package day5;

public class OperatorCheck {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c;
		int d;
		
		c = ++b;
		System.out.println("c: "+c);
		
		d = a++;
		System.out.println("d: "+d);
		
		c++;		
		System.out.println("c: "+c);
		System.out.println("a: "+a);
		System.out.println("b: "+b);
	}
}
