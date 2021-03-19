package day9;

import java.util.*;

public class ExceptionQuestion9 {
	int numStudents, totalMarks, count;
	Scanner s;

	ExceptionQuestion9() {
		this.totalMarks = 0;
		this.count = 0;
		this.s = new Scanner(System.in);
		System.out.println("Enter number of students: ");
		this.numStudents = s.nextInt();
	}

	private void getInput() throws Exception {
		System.out.println("Enter marks: ");
		String marks = this.s.next();
		int n = Integer.parseInt(marks);

		if (n > 100)
			throw new MarkOutOfBoundException("marks should be in the range of 0 to 100");

		if (n < 0)
			throw new NegativeMarkException("marks cannot be negative");

		this.totalMarks += n;
		this.count++;
	}

	private double getAverage() {
		return (double) this.totalMarks / this.numStudents;
	}

	private boolean isFull() {
		return (this.count == this.numStudents);
	}

	public static void main(String[] args) {

		ExceptionQuestion9 obj = new ExceptionQuestion9();

		while (true) {

			try {
				obj.getInput();
				if (obj.isFull())
					break;
			} catch(MarkException e) {
				System.out.println("Invalid input");
				MarkExceptionHandler handler = new MarkExceptionHandlerImpl();
				e.handle(handler);
			}catch(Exception e) {
				System.out.println("Invalid input");				
			}
		}

		System.out.println("Average marks: " + obj.getAverage());
	}

}
abstract class MarkException extends Exception{
	abstract void handle(MarkExceptionHandler handler);
}

class MarkOutOfBoundException extends MarkException {
	private String message;

	MarkOutOfBoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}

	@Override
	void handle(MarkExceptionHandler handler) {
		handler.handle(this);
	}
}

class NegativeMarkException extends MarkException {
	private String message;

	NegativeMarkException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
	@Override
	void handle(MarkExceptionHandler handler) {
		handler.handle(this);
	}
}

interface MarkExceptionHandler{
	void handle(MarkOutOfBoundException exception);
	void handle(NegativeMarkException exception);
}

class MarkExceptionHandlerImpl implements MarkExceptionHandler{

	@Override
	public void handle(MarkOutOfBoundException exception) {
		System.out.println("Marks cannot be greater than 100");
	}

	@Override
	public void handle(NegativeMarkException exception) {
		System.out.println("Marks cannot be negative");
	}
	
}