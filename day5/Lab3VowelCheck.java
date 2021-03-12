package day5;

import java.util.*;

public class Lab3VowelCheck {

	static boolean checkVowel(char c) {
		switch (c) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		default:
			return false;
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter some text: ");
		String input = s.nextLine();
		
		char[] charArr = input.toCharArray();
		for(int i = 0; i < input.length(); i++) {
			if(checkVowel(charArr[i])) {
				System.out.println(charArr[i]+" IS A VOWEL");
			}
		}	 
	}
}
