package day9;

public class ExceptionQuestion2 {
 
	private void methodOne() {
		methodTwo();
		System.out.println("caller");
	}
	
	private void methodTwo() {
		try {
			throw new Exception();
			//return;
			//System.exit(0);
		}catch(Exception e){
			System.out.println("catch methodTwo");
		}finally {
			System.out.println("finaly methodTwo");
		}
	}
	
	public static void main(String[] args) {
		
		ExceptionQuestion2 obj = new ExceptionQuestion2();
		obj.methodOne();
	}
}
