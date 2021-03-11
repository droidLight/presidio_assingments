package day4;

public class Question4 {

	static boolean checkPrime(int n) {
		boolean isPrime = true;

		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static void main(String args[]) {

		int num = 31;
		
		if(num == 1) {
			System.out.println("Neither prime nor composite");
		}else {
			String result = checkPrime(num)?(num + " is prime"):(num+" is not prime");
			System.out.println(result);
		}
	}
}
