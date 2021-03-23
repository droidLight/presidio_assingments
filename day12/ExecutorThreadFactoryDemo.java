package day12;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

public class ExecutorThreadFactoryDemo {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(1, new ThreadFactory() {

			@Override
			public Thread newThread(Runnable r) {
				Thread t = Executors.defaultThreadFactory().newThread(r);
				t.setName("thread created From thread factory");
				System.out.println("Thread Created");
				return t;
			}
			
		});
		
		es.execute(()->{
			System.out.println("inside thread");
			System.out.println("Thread name: "+Thread.currentThread().getName());
		});
	}
}
