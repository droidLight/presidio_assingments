package day11;

import java.util.concurrent.*;

public class ThreadLocalDemo {
	
	public static void main(String[] args) {
		
		ExecutorService services = Executors.newFixedThreadPool(2);
		
		services.execute(()->{
			Resource resOne = ThreadUtility.getResource("first thread one");
			System.out.println(resOne);
			
			Resource resTwo = ThreadUtility.getResource("first thread two");
			System.out.println(resTwo);
			
		});
		
		services.execute(()->{
			Resource resOne = ThreadUtility.getResource("second thread one");
			System.out.println(resOne);
			
			Resource resTwo = ThreadUtility.getResource("second thread two");
			System.out.println(resTwo);
			
		});
		
		services.shutdown();
		
	}
}

class ThreadUtility{
	
	private static ThreadLocal<Resource> threadLocal = new ThreadLocal();
	
	synchronized public static Resource getResource(String name) {
		
		Resource resource = (Resource)threadLocal.get();
		if(resource == null) {
			resource = new Resource(name);
			threadLocal.set(resource);
		}
		resource.name = name;
		return resource;
	}
	
	synchronized public static void closeResource() {
		Resource resource = (Resource) threadLocal.get();
		if(resource != null) {
			threadLocal.remove();
		}
	}
}


class Resource{
	String name;
	
	Resource(String name){
		this.name = name;
		System.out.println("Resource constructor called");
	}
	
	public String toString() {
		return this.name;
	}
}
