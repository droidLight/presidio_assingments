package day5;

import java.io.Console;

public class ConsoleExample {
	public static void main(String[] args) {
		Console con = System.console();
		
		if(con != null) {
			char[] password = null;
			
			try {
				password = con.readPassword("Input Password");
				
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				System.out.println("Entered Password: "+new String(password));
			}
		}else {
			System.out.println("Console not available");
		}
		
	}
}
