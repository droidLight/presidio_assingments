package day5;

import java.util.*;

public class Lab4CheckPrime {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int num = s.nextInt();
		if (num == 1) {
			int count = 2;
			boolean isPrime = true;
			while (count < num / 2) {
				if (num % count == 0)
					isPrime = false;
				count++;
			}

			System.out.println(isPrime ? (num + " is prime") : (num + " is not prime"));
		}else {
			System.out.println("Neither prime nor composite");
		}

	}
}
