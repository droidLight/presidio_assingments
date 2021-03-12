package day5;

import java.util.*;

public class Lab4SumOfDigits {
	
	static int sumOfDigits(int n) {
		int sum = 0;
		 while(n > 0) {
			 int lastDigit = n % 10;
			 sum  += lastDigit;
			 n /= 10;
		 }
		 return sum;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int n = s.nextInt();
		
		System.out.println("Sum of digits of "+n+" is "+sumOfDigits(n));
		s.close();
	}
}
