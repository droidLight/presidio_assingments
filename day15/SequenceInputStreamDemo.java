package day15;

import java.io.*;

public class SequenceInputStreamDemo {
	
	public static void main(String[] args) throws Exception{
		
		ByteArrayInputStream bisOne = new ByteArrayInputStream("sample string one".getBytes());
		ByteArrayInputStream bisTwo = new ByteArrayInputStream("sample string two".getBytes());
		
		SequenceInputStream sis = new SequenceInputStream(bisOne, bisTwo);
		
		int i;
		while((i = sis.read()) != -1) {
			
			System.out.println((char)i);
		}
	}
}
