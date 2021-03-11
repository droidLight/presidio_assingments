package day4;

class ProtectedData{
	protected int data = 10;
}

public class Question23 {
	public static void main(String[] args) {
		ProtectedData obj = new ProtectedData();
		System.out.println("Original value: "+obj.data);
		obj.data = 1000;
		System.out.println("modified value: "+obj.data);
	}
}
