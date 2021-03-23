package day11;

import java.util.concurrent.*;

public class CallableDemo {

	public static void main(String[] args) throws Exception {

		ExecutorService es = Executors.newFixedThreadPool(1);

		Future future = es.submit(new MyCallable());
//		try {
//			Thread.sleep(500);
//		}catch(Exception e) {}
		System.out.println("main thread");

		String result = (String) future.get();
		System.out.println(result);

		es.shutdown();
	}
}

class MyCallable implements Callable {

	@Override
	public Object call() throws Exception {
		System.out.println("call method");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		return "Hello world";
	}

}