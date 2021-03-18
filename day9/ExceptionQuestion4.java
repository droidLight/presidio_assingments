package day9;

public class ExceptionQuestion4 {
	
	public static void main(String[] args) {
		
		try {
			throw new MyException("Test error message");
		}catch(MyException e) {
			System.out.println(e);
		}
	}
}


class MyException extends Exception{
	private String message;
	
	MyException(String message){
		this.message = message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}