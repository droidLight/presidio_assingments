package day5;

import java.util.*;

public class Lab4Fibonaci {
	static int[] generateFibonaci(int n) {
	
		int[] series = new int[n];
		series[0] = 0;
		series[1] = 1;
		
		for(int i = 2; i < n;i++) {
			series[i] = series[i-2] + series[i-1];
		}
		
		return series;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of times to repeat: ");
		int n = s.nextInt();
		
		for(int i : generateFibonaci(n)) {
			System.out.print(i+" \t");
		}
		s.close();

	}
}
