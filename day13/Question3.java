package day13;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Question3 {

	public static void main(String[] args) {
		
//		Set set = new TreeSet();
//		set.add("2");
//		set.add(3);
//		set.add("1");
//		Iterator it = set.iterator();
//		while (it.hasNext()) {
//			System.out.print(it.next() + " ");
//		}
		
		Set<String> stringStr = new TreeSet();
		stringStr.add("3");
		stringStr.add("2");
		stringStr.add("1");
		Iterator it = stringStr.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
