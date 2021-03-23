package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerDemo {
	
	public static void main(String[] args) {
		Gun gun = new Gun();
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		//fill thread
		es.execute(()->{
			for(int i = 0; i < 5; i++) {
				gun.fill();
			}
		});
		
		//fire thread
		es.execute(()->{
			for(int i = 0; i < 5; i++) {
				gun.shoot();
			}
		});
		
		es.shutdown();
	}
}

class Gun{
	boolean flag;
	
	synchronized public void fill() {
		if(flag) {
			try {
				wait();
			}catch(Exception e) {}
		}
		flag = true;
		System.out.println("Gun is loaded");
		notify();
	}
	
	synchronized public void shoot() {
		if(!flag) {
			try {
				wait();
			}catch(Exception e) {}
		}
		flag = false;
		System.out.println("Gun is fired");
		notify();
	}
}