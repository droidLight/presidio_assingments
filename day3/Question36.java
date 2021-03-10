package day3;

public class Question36 {
	public static void main(String argv[]) {
		Question36 e = new Question36();
	}

	Question36() {
		String s = "Java";
		String s2 = "java";
		if (s.equalsIgnoreCase(s2)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not equal");
		}
	}
}
