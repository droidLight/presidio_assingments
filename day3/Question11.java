package day3;

abstract class MineBase{
	static int i;
	abstract void amethod();
}

public class Question11 extends MineBase{

	public static void main(String args[]) {
		int[] arr= new int[5];
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}//error: should implement abstract methods from abstract class.
	void amethod() {} //solution
	
	
	
}
