package day5;

import java.util.*;

public class Lab4EvenNumInRange {
	
	static void findEvenNumbers(int start, int end) {
		while(start < end) {
			if(start % 2 == 0)
				System.out.println(start+" is even number");
			start++;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter starting num: ");
		int start = s.nextInt();
		System.out.println("Enter ending num: ");
		int end = s.nextInt();
		
		findEvenNumbers(start, end);
		s.close();
	}
}
