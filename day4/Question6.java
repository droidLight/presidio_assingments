package day4;
import java.util.*;

public class Question6 {

	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter size of array: ");
		int origSize = s.nextInt();
		int[] origArr = new int[origSize];
		for(int i =0; i<origSize; i++) {
			origArr[i] = s.nextInt();
		}
		
		System.out.println("Enter the size of new array: ");
		int expSize = s.nextInt();
		int[] newArr = new int[origArr.length+expSize];
		
		System.arraycopy(origArr, 0, newArr, 0, origSize);
		
		for(int i =0; i<newArr.length; i++) {
			System.out.print(newArr[i]+"\t");
		}
		
		System.out.println("\nNew Length: "+newArr.length);
		s.close();
	}
}
