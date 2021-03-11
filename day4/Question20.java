package day4;

public class Question20 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 16, 17 } };
		
		int[] maxElements = new int[arr.length];
		int index = 0;
		for(int[] row : arr) {
			int max = Integer.MIN_VALUE;
			for(int i : row) {
				if(i > max)
					max = i;
			}
			maxElements[index] = max;
			index++;
		}
		
		for(int max : maxElements) {
			System.out.println(max);
		}
	}
}
