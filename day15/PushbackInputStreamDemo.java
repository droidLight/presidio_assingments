package day15;

import java.io.*;

public class PushbackInputStreamDemo {
	
	public static void main(String[] args) throws Exception{
		String str = "supportstaff";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		PushbackInputStream pis = new PushbackInputStream(input);
		
		int i;
		while((i = pis.read()) != -1) {
			
			if(((char)i) == 's') {
				pis.unread('S');
			}else {
				System.out.println((char)i);
			}
		}
	
	}
}
