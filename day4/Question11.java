package day4;

public class Question11 {
	public static void main(String[] args) {
		
		int[][] arr = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
		
		for(int[] row : arr) {
			for(int i : row) {
				System.out.print(i+"\t");
			}
			System.out.println("");
		}
	}
}
