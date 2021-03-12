package day5;

import java.util.*;

public class Lab4MultTable {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int n = s.nextInt();

		System.out.println("Enter a number till we calculate: ");
		int end = s.nextInt();
		
		int iter = 1;
		int current = n * iter;
		do {
			
			System.out.println(current);
			iter++;
			current = iter * n;
		} while (current <= end);
		s.close();
	}
}
