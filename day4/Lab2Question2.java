package day4;

class ComplexNum{
	int x, y;
	
	ComplexNum(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void addComplexNum(ComplexNum num) {
		this.x += num.x;
		this.y += num.y;
	}
	
	public String toString() {
		return this.x+" + "+this.y+"i";
	}
}

public class Lab2Question2 {
	public static void main(String[] args) {
		ComplexNum num1 = new ComplexNum(20, 23);
		System.out.println(num1);
		
		ComplexNum num2 = new ComplexNum(2, 40);
		System.out.println(num2);
		
		num1.addComplexNum(num2);
		System.out.println(num1);
	}
}
