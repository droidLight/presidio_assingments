package day3;

public class Question44 {
	public static void main(String argv[]) {
		Question44 o = new Question44();
		o.amethod();
	}

	public void amethod() {
		int oi = 012; //0 at begining means the input form is in octal format.
		System.out.println(oi); // when printed, the octal format is converted into decimal. which is 10
	}
}
