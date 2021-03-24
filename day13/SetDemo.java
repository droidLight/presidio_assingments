package day13;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class SetDemo {
	
	public static void main(String[] args) {
		
		//Set<String> set = new HashSet<>();
		Set<Student> set = new TreeSet<>((o1, o2)->{return o1.compareTo(o2);});
		
		set.add(new Student(200));
		set.add(new Student(100));
		set.add(new Student(600));
		set.add(new Student(50));
		
		System.out.println(set);
	}
}


class Student implements Comparable<Student>{
	int marks;
	Student(int marks) {this.marks = marks;}
	
	@Override
	public int compareTo(Student o) {
		//return o.marks - this.marks;
		return Integer.valueOf(this.marks).compareTo(Integer.valueOf(o.marks));
	}
	@Override
	public String toString() {
		return ""+this.marks;
	}
}