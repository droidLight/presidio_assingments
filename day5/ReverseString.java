package day5;
import java.util.*;

public class ReverseString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		String strArr[]  = str.split("");
		String reverseStr = "";
		
		for(int i = strArr.length-1; i >= 0; i--) {
			reverseStr = reverseStr + strArr[i];
		}
		System.out.println(reverseStr);
		s.close();
	}
}
