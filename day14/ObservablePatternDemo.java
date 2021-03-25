package day14;

import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ObservablePatternDemo {
	
	public static void main(String[] args) {
		
		Fire fire = new Fire();
		fire.addObserver(new Student());
		fire.addObserver(new Teacher());
		fire.addObserver(new Others());
		fire.setFire();
	}
}

//observable with threads
class ThreadedObservable extends Observable{
	List<Observer> observerList;
	public ThreadedObservable(){
		this.observerList = new ArrayList<>();
	}
	
	@Override
	public synchronized void addObserver(Observer ob) {		
		this.observerList.add(ob);
	}
	
	@Override
	public void notifyObservers(Object arg) {
		ExecutorService thread = Executors.newFixedThreadPool(this.observerList.size());
		for(Observer observer : this.observerList) {
			thread.execute(()->{
				observer.update(ThreadedObservable.this, arg);
			});
		}
		thread.shutdown();
	}
}

class Fire extends ThreadedObservable{
	public void setFire() {
		System.out.println("started fire");
		setChanged();
		notifyObservers("odra odra");
	}
} 

class Student implements Observer{
	
	@Override
	public void update(Observable o, Object arg) {	
		runAway((String) arg);
	}
	
	private void runAway(String msg) {
		System.out.println("Students running, msg: "+msg);
	}
	
}

class Teacher implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		runAway((String)arg);
	}
	
	private void runAway(String msg) {
		try {
			Thread.sleep(6000);
		}catch(Exception e) {}
		System.out.println("Teacher running, msg: "+msg);
	}
	
}

class Others implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		runAway((String)arg);
	}
	
	private void runAway(String msg) {
		try {
			Thread.sleep(2000);
		}catch(Exception e) {}
		System.out.println("Others running, msg: "+msg);
	}
	
}