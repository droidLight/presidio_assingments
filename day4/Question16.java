package day4;

import java.util.*;

public class Question16 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the num of elements: ");
		int n = s.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		System.out.println("Enter the array elements: ");
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			int count = map.getOrDefault(arr[i], 0);
			map.put(arr[i], count+1);
			
		}

		System.out.println("Enter element to find: ");
		int num = s.nextInt();

		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (arr[i] == num) {
				flag = true;
				System.out.println("Found " + num + " at index: " + i+" Frequency: "+map.get(num));
			}
		}

		if (!flag)
			System.out.println("Element not present");

		s.close();
	}
}
