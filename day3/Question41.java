package day3;

public class Question41 {
	static int j = 20;

	public static void main(String argv[]) {
		int i = 10;
		Question41 q = new Question41();
		q.amethod(i);
		System.out.println(i);
		System.out.println(j);
	}

	public void amethod(int x) {
		x = x * 2;
		j = j * 2;
	}
}
/*output:
 * 10
 * 40
 */
