package day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class VectorDemo {
	
	public static void main(String[] args) {
		
		Vector<String> vector = new Vector<>(10, 5);
		
		vector.add("aaaa");
		vector.add("bbbb");
		vector.add("cccc");
		
		Iterator<String> iterator = vector.iterator();
		//vector.add("dddd"); //throws error
		while(iterator.hasNext()) {System.out.println(iterator.next());}
		
		Enumeration<String>enumeration = vector.elements();
		vector.add("dddd"); //does not throw error such as adding after iterator is created
		while(enumeration.hasMoreElements()) {System.out.println(enumeration.nextElement());}
		
	}
}
