package day5;

import java.util.*;

public class Lab5ArrayReverse {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = s.nextInt();
		
		int[] arr = new int[n];
		System.out.println("Enter elements: ");
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		System.out.println("Reversing array");
		for(int i = arr.length-1; i >=0;i--) {
			System.out.print(arr[i]+"\t");
		}
		s.close();
	}
}
