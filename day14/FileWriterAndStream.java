package day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;

public class FileWriterAndStream {

	public static void main(String[] args) throws Exception {

//		FileInputStream fin = new FileInputStream("abc.properties");
//		FileOutputStream fout = new FileOutputStream("output_abc.properties");

		try (FileReader fReader = new FileReader("abc.properties");
				FileWriter fWriter = new FileWriter("output_abc.properties",true);) {
			
			int i = 0;
			char b[] = new char[8];
			
			while((i = fReader.read(b)) != -1) {
				System.out.println("Number of bytes read...: "+i);
				String str = new String(b);
				fWriter.write(b, 0, i);
			}
		} catch (Exception e) {
		}
	}
}
