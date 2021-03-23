package day12;

public class GenericsDemoTwo {
	
	static <T> void printArray(T[] arr) {
		for(T obj : arr) {
			System.out.print(obj+"\t");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		Integer[] integerArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String[] stringArr = {"AB", "CD", "EF", "GH", "IJ"};
		Double[] doubleArr = {1.1, 2.2, 3.3 , 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.10};
		Character[] characterArr = {'A', 'B', 'C', 'D', 'E', 'F'};
		
		printArray(integerArr);
		printArray(stringArr);
		printArray(doubleArr);
		printArray(characterArr);
	}
	
}
