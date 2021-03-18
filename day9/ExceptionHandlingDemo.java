package day9;
import java.util.*;

public class ExceptionHandlingDemo {

	public static void main(String[] args){
		System.out.println("enter class name");
		Scanner s = new Scanner(System.in);
		String itemClass= s.next();
		
		try {
			Dog dog = new Dog();
			Item item = (Item) Class.forName(itemClass).getConstructor().newInstance();
			dog.playWithDog(item);
		} catch (DogException exception) {
			System.out.println(exception);
			DogExceptionHandler handler = new DogExceptionHandlerImpl();
			exception.handle(handler);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

class Dog {
	public void playWithDog(Item item) throws DogException {
		item.execute();
	}
}

abstract class Item {
	abstract void execute() throws DogException;
}

class Stick extends Item {
	public Stick(){}
	@Override
	void execute() throws DogException {
		throw new DogExceptionBite("Dog bit me");
	}
}

class Biscuit extends Item {
	public Biscuit(){}
	@Override
	void execute() throws DogException {
		throw new DogExceptionHappy("Dog is Happy");
	}
}

//creating custom exceptions 
abstract class DogException extends Exception {
	abstract public void handle(DogExceptionHandler handler);

	abstract public String toString();
}

class DogExceptionBite extends DogException {
	String msg;

	DogExceptionBite(String msg) {
		this.msg = msg;
	}

	@Override
	public void handle(DogExceptionHandler handler) {
		handler.handle(this);
	}

	@Override
	public String toString() {
		return this.msg;
	}
}

class DogExceptionHappy extends DogException {
	String msg;

	DogExceptionHappy(String msg) {
		this.msg = msg;
	}

	@Override
	public void handle(DogExceptionHandler handler) {
		handler.handle(this);
	}

	@Override
	public String toString() {
		return this.msg;
	}
}

//dog exception handler
interface DogExceptionHandler {
	void handle(DogExceptionBite dogExceptionBite);

	void handle(DogExceptionHappy dogExceptionHappy);
}

class DogExceptionHandlerImpl implements DogExceptionHandler {

	@Override
	public void handle(DogExceptionBite dogExceptionBite) {
		System.out.println("Go to vetnary.");
	}

	@Override
	public void handle(DogExceptionHappy dogExceptionBark) {
		System.out.println("play with it");
	}
}
