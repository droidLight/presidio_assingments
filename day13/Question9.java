package day13;

import java.util.*;

public class Question9 {
	
	public static void main(String[] args) {
		
		Object o = new Object();
		
		//Set s = new HashSet();
		//TreeSet s = new TreeSet(); //runtime error. needs to implement Comparable
		LinkedHashSet s = new LinkedHashSet();
		
		s.add(o);
		s.add("o");
		
		System.out.println(s);
	}
}
