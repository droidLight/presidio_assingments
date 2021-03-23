package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo2 {
	
	public static void main(String[] args) {
		
		System.out.println("First Line");
//		new Thread(()->{
//			methodOne();
//		}).start();
		ExecutorService ex = Executors.newFixedThreadPool(1);
		ex.execute(()->{
			methodOne();
		});		
		System.out.println("Third Line");
		ex.shutdown();
	}
	static void methodOne() {
		try {
			Thread.sleep(5000);
		}catch(Exception e) {}
		System.out.println("Second Line");
	}
}
