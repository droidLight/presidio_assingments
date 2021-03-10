package day3;

public class Question51 {
	private int i; //cannot use non-static variable in static method 
	//private static int i;
	public static void main(String argv[]) {
		Question51 s = new Question51();
		s.amethod();
	}

	public static void amethod() {
		System.out.println(i);
	}
}
