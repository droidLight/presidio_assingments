package day5;

import java.util.Scanner;

public class Lab2LargestNum {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		int a = s.nextInt();
		System.out.println("Enter second number: ");
		int b = s.nextInt();
		System.out.println("Enter third number: ");
		int c = s.nextInt();
		
		if(a > b && a >  c) {
			System.out.println(a+" is the largest number");
		}else if(b > a && b > c) {
			System.out.println(b+" is the largest number");
		}else {
			System.out.println(c+" is the largest number");
		}
		
	}
}
