package day13;

import java.util.*;

public class CollectionsDemo {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>(30);
		
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("q");
		list.add("g");
		list.add("f");
		
		System.out.println("For loop-----");
		for(String str : list) {
			System.out.println(str);
		}
		
		System.out.println("iterator-----");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("List iterator has previous-----");
		ListIterator<String> listIterator = list.listIterator();
		while(listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
		
		System.out.println("List iterator has next-----");
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		
		System.out.println("List iterator has previous-----");
		while(listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
		
//		System.out.println("sorting by comparator-----");
//		list.sort(new MyComparator());
//		for(String str:list) {System.out.println(str);}
		
		System.out.println("sorting by lambda-----");
		list.sort((o1, o2)->{
			return o1.compareTo(o2);
		});
		for(String str:list) {System.out.println(str);}
	}
}


class MyComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}