package day11;

import java.util.concurrent.*;

public class OneObjectTwoThreadDemo {

	public static void main(String[] args) {
		ReservationCounter obj = new ReservationCounter();
		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(() -> {
			Thread.currentThread().setName("p1");
			synchronized(obj) {
				obj.bookTicket(1000);
				obj.getChange();
			}			
		});
		
		es.execute(()->{
			Thread.currentThread().setName("p2");			
			synchronized(obj) {
				obj.bookTicket(500);
				obj.getChange();
			}			
		});
	}
}

class ReservationCounter {
	int amount;

	 public void bookTicket(int amount) {
		this.amount = amount;
		Thread t = Thread.currentThread();
		System.out.println("Ticket booked by: " + t.getName() + " amount: " + this.amount);
	}

	 public void getChange() {
		Thread t = Thread.currentThread();
		System.out.println("Change being given to: " + t.getName() + " amount: " + (this.amount - 100));
	}
}