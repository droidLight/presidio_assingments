package day3;

public class Question35 {
	public static void main(String argv[]) {
		Question35 c = new Question35();
		String s = new String("ello");
		c.amethod(s);
	}

	public void amethod(String s) {
		//char c = 'H';
		//c += s; //cannot use this for char and string
		String c = "H"+s;
		System.out.println(c);
	}
}
