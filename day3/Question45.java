package day3;

public class Question45 {
	int i = 2; // without this there would be runtime error.
	//after adding "int i" variable, the output will be "99"
	public static void main(String argv[]) {
		Question45 r = new Question45();
		r.amethod(r);
	}

	public void amethod(Question45 r) {
		int i = 99;
		multi(r);
		System.out.println(i);
	}

	public void multi(Question45 r) {
		r.i = r.i * 2;
	}
}
