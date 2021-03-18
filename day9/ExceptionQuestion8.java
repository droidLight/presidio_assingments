package day9;
import java.util.*;

public class ExceptionQuestion8 {
	int numStudents, totalMarks;
	Scanner s;
	
	ExceptionQuestion8(){
		this.totalMarks = 0;
		this.s = new Scanner(System.in);
		System.out.println("Enter number of students: ");
		this.numStudents = s.nextInt();
	}
	
	private int getInput() throws NumberFormatException{
		System.out.println("Enter marks: ");
		String marks = this.s.next();
		return Integer.parseInt(marks);		
	}
	
	private double getAverage() {
		return (double) this.totalMarks / this.numStudents;
	}
	
	public static void main(String[] args) {
		
		ExceptionQuestion8 obj = new ExceptionQuestion8();
		int count = 1;
		while(true) {
			
			try {
				int marks = obj.getInput();
				obj.totalMarks += marks;
				
				if(obj.numStudents == count)
					break;
				else
					++count;
			}catch(NumberFormatException e) {
				System.out.println("Invalid input: "+e);
			}
		}
		
		System.out.println("Average marks: "+obj.getAverage());
	}
	
	
}
