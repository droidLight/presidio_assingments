package day5;

import java.util.*;

public class Lab4Palindrome {
	
	static void printPalindrome(String str) {
		
		int length = str.length() - 1;
		char[] strArr = str.toCharArray();
		while(length >= 0) {			
			System.out.print(strArr[length]);
			length--;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter some string: ");
		String str = s.next();
		printPalindrome(str);
		s.close();
	}
}
