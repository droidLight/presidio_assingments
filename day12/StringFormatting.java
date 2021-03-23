package day12;

public class StringFormatting {
	public static void main(String[] args) {
		float varFloat = 34.46474747474747474747473363f;
		int varInt = 10;
		String varString = "This is string";
		
		System.out.printf("integer: %d\tString: %s\tfloat:%f", varInt, varString,  varFloat);
		System.out.println("width example");
		System.out.printf("%-10s%-10s%-10s%-10s", "c1", "c2", "c3", "c4");
		System.out.println("\n");
		System.out.printf("%10s%10s%10s%10s",  "c1", "c2", "c3", "c4");
	}
}
