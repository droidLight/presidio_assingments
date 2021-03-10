package day3;

class ParentClassTwo { //remove private access modifier to fix compile time error
	ParentClassTwo() {
		int i = 100;
		System.out.println(i);
	}
}

public class Question43 extends ParentClassTwo {
	static int i = 200;

	public static void main(String argv[]) {
		Question43 p = new Question43();
		System.out.println(i);
	}
	
}
/*output:
 * 100
 * 200
 */
