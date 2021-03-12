package day5;

import java.util.Scanner;

public class Lab5BiggestInArray {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = s.nextInt();
		
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		System.out.println("Enter elements: ");
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			if(max < arr[i])
				max = arr[i];
			if(min > arr[i])
				min = arr[i];
		}
		
		System.out.println("Max: "+max+" Min: "+min);
		s.close();
	}
}