package day9;

import java.io.IOException;

public class ExceptionQuestion1 {
	
	public static void main(String[] args) {
		
	}
	
	private void testMethod() throws IOException{
		throw new IOException(); //compile time error without using "throws" or "try-catch"
	}
}
