package day9;

public class ExceptionQuestion6 {
	public static void main(String[] args) {
		
		try {
			DerivedClass obj = new DerivedClass();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

class SuperClass{
	public SuperClass() throws Exception{
		System.out.println("SuperClass constructor");
		throw new Exception();
	}
}

class DerivedClass extends SuperClass{
	
	public DerivedClass() throws Exception{
		System.out.println("DerivedClass constructor");
	}
}