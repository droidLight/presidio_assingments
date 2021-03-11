package day4;

public class Question15 {

	static void printPrimeNumbers(int n) {
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= 100; i++) {
			if (prime[i]) {

				for (int j = i * i; j <= 100; j += i) {
					prime[j] = false;
				}
			}
		}

		// list of all prime numbers
		for (int i = 2; i < prime.length; i++) {
			if (prime[i])
				System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {

		int n = 100;
		printPrimeNumbers(n);
		
		
	}
}
