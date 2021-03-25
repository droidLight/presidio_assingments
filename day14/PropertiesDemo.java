package day14;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {
	
	public static void main(String[] args) throws Exception{
		
		Properties properties = new Properties();
		
//		properties.put("key1", "value1");
//		properties.put("key2", "value2");
//		properties.put("key3", "value3");
		
		//reading from file
		properties.load(new FileInputStream("demo.properties"));
		
		Enumeration enumerations = properties.elements();
		while(enumerations.hasMoreElements()) {
			System.out.println(enumerations.nextElement());
		}
	}
}
