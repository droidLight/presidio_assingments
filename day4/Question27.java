package day4;

public class Question27 {
	public static void main(String[] args) {
		double initialAmount = 14000;
		double finalAmount = 0;
		
		//first year
		finalAmount = initialAmount + initialAmount * (0.4);
		
		//second year
		finalAmount = finalAmount - (double) 1500;
		
		//third year
		finalAmount = finalAmount + finalAmount * (0.12);
		
		System.out.println(finalAmount);
	}
}
