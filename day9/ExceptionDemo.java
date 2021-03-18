package day9;

public class ExceptionDemo {
	public static void main(String[] args) {
		System.out.println("before exception");
		int[] testArr = new int[3];
		try {
			int i = 400 / Integer.parseInt("40");
			System.out.println(testArr[i]);
		} catch (ArithmeticException e) {
			System.out.println("aritmetic error: " + e);
		} catch (NumberFormatException e) {
			System.out.println("number format error: " + e);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("array index out of bounds error: " + e);
		}catch (Exception e) {
			System.out.println("general error: " + e);
		}
		System.out.println("after exception");		
				
	}
}
