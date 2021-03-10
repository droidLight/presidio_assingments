package day3;

class MyThread implements Runnable {
	int i = 0;

	public void run() {//change return type from int to void
		while (true) {
			i++;
			System.out.println("i=" + i);
		} // End while
		//return 1; // removed return statement
	}// End run
	
}

public class Question33{
	public static void main(String args[]){
		
		Thread t = new Thread(new MyThread());
		t.start();
	}
}
