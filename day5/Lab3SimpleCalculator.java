package day5;

import java.util.*;

public class Lab3SimpleCalculator {
	// constants to improve readability
	final static int ADD = 1;
	final static int SUB = 2;
	final static int MUL = 3;
	final static int DIV = 4;

	static float calculate(float a, float b, int option) {

		switch (option) {
		case ADD:
			return a + b;
		case SUB:
			return a - b;
		case MUL:
			return a * b;
		case DIV:
			return a / b;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter operand one: ");
		float op1 = s.nextFloat();

		System.out.println("Enter operand two: ");
		float op2 = s.nextFloat();

		System.out.println("1.ADD\t2.SUB\t3.MUL\t4.DIV\nSelect an option: ");
		int opr = s.nextInt();

		System.out.println("Answer: " + calculate(op1, op2, opr));
		s.close();

	}
}
