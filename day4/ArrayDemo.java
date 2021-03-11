package day4;

public class ArrayDemo {
	
	public static void main(String[] args) {
		
		int[] arrOne = new int[5];
		for(int i = 0; i < arrOne.length; i++) {
			arrOne[i] = i;
		}
		
		int[][] twoDimen = new int [4][4];
		for(int i = 0; i < twoDimen.length; i++) {
			for(int j = 0; j < twoDimen[i].length; j++) {
				twoDimen[i][j] = i * j;
				System.out.print(twoDimen[i][j]+"\t");
			}	
			System.out.println("");
		}
	}
}
