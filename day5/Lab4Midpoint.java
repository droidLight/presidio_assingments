package day5;

import java.util.*;

public class Lab4Midpoint {
	
	static double findMidpoint(int start, int end) {
		return (start + end) / 2;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter starting num: ");
		int start = s.nextInt();
		System.out.println("Enter ending num: ");
		int end = s.nextInt();

		System.out.println("Midpoint: "+findMidpoint(start, end));
		s.close();
	}
}
