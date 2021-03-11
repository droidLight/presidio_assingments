package day4;

import java.util.Scanner;

public class Question9 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = s.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
				
		//reverse array
		for(int i = 0; i < n/2; i++) {
			int temp = arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = temp;
		}
		for(int i : arr) {
			System.out.print(i+" \t");
		}	
	}
}
