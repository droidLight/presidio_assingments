package day4;

public class Question2 {

	int i;
	short s;
	long l;
	byte b;
	char c;

	float f;
	double d;

	boolean bo;

	void printDefault() {
		System.out.println("int: " + i + "\nshort: " + s + "\nlong: " + l + "\nbyte: " + b + "\nchar: " + c
				+ "\nfloat: " + f + "\ndouble: " + d + "\nboolean: " + bo);
	}

	public static void main(String[] args) {
		Question2 obj = new Question2();
		obj.printDefault();
	}
}
