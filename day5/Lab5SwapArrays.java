package day5;

import java.util.*;

public class Lab5SwapArrays {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = s.nextInt();

		int[] arrOne = new int[n];
		System.out.println("Enter elements for array 1");
		for (int i = 0; i < n; i++) {
			arrOne[i] = s.nextInt();
		}
		
		int[] arrTwo = new int[n];
		System.out.println("Enter elements for array 2");
		for (int i = 0; i < n; i++) {
			arrTwo[i] = s.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			arrOne[i] = arrOne[i] + arrTwo[i];
			arrTwo[i] = arrOne[i] - arrTwo[i];
			arrOne[i] = arrOne[i] - arrTwo[i];
		}
		
		System.out.println("Array one");
		for (int i = 0; i < n; i++) {
			System.out.print(arrOne[i]+"\t");
		}
		System.out.println("\nArray Two");
		for (int i = 0; i < n; i++) {
			System.out.print(arrTwo[i]+"\t");
		}
	}
}
