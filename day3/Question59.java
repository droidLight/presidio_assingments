package day3;

class BaseTwo {
	private void amethod(int iBase) {
		System.out.println("Base.amethod");
	}
}

class Question59 extends Base {
	public static void main(String argv[]) {
		Question59 o = new Question59();
		int iBase = 0;
		o.amethod(iBase);
	}

	public void amethod(int iOver) {
		System.out.println("Over.amethod");
	}
}/*Output:
*Over.amethod
*/