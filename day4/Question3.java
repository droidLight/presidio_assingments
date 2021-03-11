package day4;

public class Question3 {
	int i;
	short s;
	long l;
	byte b;
	char c;

	float f;
	double d;

	boolean bo;

	void initialize() {
		i = 10;
		i = Integer.parseInt("10");

		s = 100;
		s = Short.parseShort("34");
		
		l = 1000000;
		l = Long.parseLong("5656565656");
		
		b = 125;
		b = Byte.valueOf("45");
		
		c = 'a';
		c = new String("HELLO").charAt(0);
		
		f = 56.8989f;
		f = Float.parseFloat("56.43365656");
		
		d = 45.67;
		d = Double.parseDouble("56.56");
		
		bo = false;
		bo = true;
		bo = Boolean.parseBoolean("true");
		bo = Boolean.parseBoolean("True");
		
		//typecast
		
		i = s;
		s = (short) i;
		
		d = (double) f;
		f = (float)d;
	}

	public static void main(String args[]) {
		
		Question3 obj = new Question3();
		obj.initialize();
	}
}
