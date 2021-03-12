package day5;

public class GenerateUniqueNumbers {
	public static void main(String[] args) {
		
		//brute force
		int amount = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					
					if(i !=j && j != k && k != i) {
						amount++;
					}
				}
			}
		}		
		System.out.println(amount);
		
		//permutation and combination
		int digits = 3;
		int totalNumbers = 4;
		
		amount = factorial(totalNumbers) / factorial(totalNumbers - digits);
		System.out.println("Amount: "+amount);
	}
	
	static int factorial(int n) {
		return (n==1)? n : n * factorial(n-1);
	}
}
