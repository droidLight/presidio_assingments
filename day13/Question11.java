package day13;

import java.util.*;

public class Question11 {
	
	public static void main(String[] args) {
		
		TreeSet<String> set = new TreeSet<>();
		TreeSet<String> setTwo = new TreeSet<>();
		
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");
		
		setTwo = (TreeSet)set.subSet("b", true, "d", true);
		set.add("g");
		System.out.println(set.pollFirst());
		System.out.println(set.pollFirst());
		set.add("c2");
		System.out.println(set.size()+" "+setTwo.size());
	}
}
