package day4;
import java.util.*;

public class Question7 {
	
	static void ascendingSort(int[] arr) {
		
		int k, j;
		for(int i = 1; i < arr.length; i++) {
			k = arr[i];
			j = i -1;
			
			while(j>=0 && arr[j] > k) {
				arr[j+1] = arr[j];
				j -= 1;
			}
			arr[j+1] = k;
		}
	}
	
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = s.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		//ascending sort
		ascendingSort(arr);
		for(int i : arr) {
			System.out.print(i+" \t");
		}
		System.out.println("");
		
		//reverse array for descending order
		for(int i = 0; i < n/2; i++) {
			int temp = arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = temp;
		}
		for(int i : arr) {
			System.out.print(i+" \t");
		}
		s.close();
	}
}
