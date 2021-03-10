package day3;

public class Question28And29 {
	
	public static void main(String args[]) {
		
		String s1 = new String("Hello");
		String s2 = new String("there");
		String s3 = new String();
		
		s3 = s1 + s2;
		/*undefined operators for string
		 * s3 = s1 - s2;
		 *s3 = s1 & s2;
		 *s3 = s1 && s2;*/
		
		System.out.println(s3);
		
		
		//question 29
		System.out.println((4 | 3)); // output 7
	}
}
