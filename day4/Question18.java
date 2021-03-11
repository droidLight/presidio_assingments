package day4;

public class Question18 {
	public static void main(String[] args) {

		int n = 20000;

		String[] unitPlace = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] tensPlace = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
				"ninty" };

		String word = "";
		int copy = n;
		int currentDigit = 0;
		while (copy > 0) {
			int d = copy % 10;
			if (currentDigit == 0) {
				word += unitPlace[d];

			} else if (currentDigit == 1) {
				word = tensPlace[d] + " " + word;

			} else if (currentDigit == 2 && d != 0) {
				word = unitPlace[d] + " hundred " + word;

			} else if (currentDigit == 3 && d != 0) {
				word = unitPlace[d] + " thousand " + word;
			} else if (currentDigit == 4 && d != 0) {
				word = tensPlace[d] + " thousand " + word;
			}
			currentDigit++;
			copy = copy / 10;
		}

		System.out.println(word);
	}
}
