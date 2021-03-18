package day9;
import java.util.*;

public class ExceptionQuestion7 {
	private static String numerator, denominator;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			
			getInput(s);
			if(numerator.equals("q") || numerator.equals("Q")) {
				break;
			}
			try {
				int i = Integer.parseInt(numerator)/Integer.parseInt(denominator);
				double d = (double) i;
				System.out.println("Quotient: "+d);
			}catch(ArithmeticException e) {
				System.out.println("Cannot divide by zero: "+e);
			}catch(NumberFormatException e) {
				System.out.println("Incorrect data: "+e);
			}catch(Exception  e) {
				System.out.println("Exception: "+e);
			}
		}
		s.close();
	}
	
	private static void getInput(Scanner s) {
		System.out.println("Enter numerator: ");
		numerator = s.next();
		
		System.out.println("Enter denominator: ");
		denominator = s.next();
	}
	
}

