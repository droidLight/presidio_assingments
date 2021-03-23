package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	
	ThreadDemo(){
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(new MyWork());
		executorService.shutdown();
	}
	 public static void main(String[] args) throws Exception{
		new ThreadDemo();
		
		 for(int i = 0; i  < 5; i++) {
			 System.out.println(i);
			 Thread.sleep(1000);
		 }
	}
}

class MyWork implements Runnable{
	
	MyWork(){
		System.out.println("MyWork constructor called");
	}
	@Override
	public void run() {
		System.out.println("run method called");
	}
}
