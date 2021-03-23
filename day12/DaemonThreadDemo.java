package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DaemonThreadDemo {
	
	public DaemonThreadDemo() {

		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
				}catch(Exception e) {}
				System.out.println("child thread....");
			}
		});
	}

	public static void main(String[] args) {
		new DaemonThreadDemo();
		System.out.println("main thread started....");
		Thread.currentThread().setDaemon(true);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.exit(1);
		System.out.println("main thread exits");
	}
}
