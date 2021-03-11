package day4;

public class Question19 {

	static void reverse(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n / 2; i++) {
			int t = arr[n - i - 1];
			arr[n - i - 1] = arr[i];
			arr[i] = t;
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 16, 17 } };

		for (int[] row : arr) {
			reverse(row);

		}

		for (int[] row : arr) {
			for (int i : row) {
				System.out.print(i + "\t");
			}
			System.out.println("");
		}
	}
}
