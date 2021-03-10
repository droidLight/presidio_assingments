package day3;

public class Question14 {

	public static void main(String args[]) {

		int i = 0;
		if (i) {
			System.out.println("hello");
		} // compile error convert int to boolean

		boolean b = true;
		boolean b2 = true;
		if (b == b2) {
			System.out.println("So true");
		} // no errors

		i = 1;
		int j = 2;
		if (i == 1 || j == 2)
			System.out.println("OK");// no errors
		
		i=1; 
		j=2; 
		if(i==1 &| j==2) 
		        System.out.println("OK"); // incorrect logical operator


	}
}
