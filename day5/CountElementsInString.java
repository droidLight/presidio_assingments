package day5;
import java.util.*;

public class CountElementsInString {

	private static Result count(String str) {
		Result result = new Result();
		char[] arr = str.toCharArray();

		for (char c : arr) {
			if (Character.isAlphabetic(c)) {
				result.letterCount++;
			} else if (Character.isDigit(c)) {
				result.digitCount++;
			} else if (Character.isSpaceChar(c)) {
				result.spaceCount++;
			} else {
				result.otherCount++;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		Result res = count(str);

		System.out.println(res);
	}

}

class Result {
	int letterCount, digitCount, spaceCount, otherCount;

	public Result() {
		this.letterCount = 0;
		this.spaceCount = 0;
		this.digitCount = 0;
		this.otherCount = 0;
	}

	public String toString() {
		return "Letter count: " + this.letterCount + "\nDigit Count: " + this.digitCount + "\nSpace count: "
				+ this.spaceCount + "\nOther count: " + this.otherCount;
	}
}