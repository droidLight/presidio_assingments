package day13;

import java.util.*;

class Question20Test {
	int size;

	public Question20Test(int s) { size = s; }

	public boolean equals(Object o) {
		return (this.size == ((Question20Test) o).size);
	}
	// this will make the size as 2
//	public int hashCode() {
//		return this.size / 5;
//	}
}

public class Question20 {

	public static void main(String[] args) {
		LinkedHashSet<Question20Test> t = new LinkedHashSet<Question20Test>();
		t.add(new Question20Test(1));
		t.add(new Question20Test(2));
		t.add(new Question20Test(1));
		System.out.println(t.size());
	}
}
