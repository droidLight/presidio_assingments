package day8;

import java.lang.reflect.*;

public class ReflectionDemo {
	
	public static void main(String[] args) throws Exception{
		
		TestClass testObj = new TestClass();
		MainClass mainClass = new MainClass();
		
		mainClass.useRefelectioAPI(testObj);
	}
}

class MainClass{
	
	void useRefelectioAPI(Object obj) throws Exception{
		Class classObj = obj.getClass();
		
		Field publicField = classObj.getField("publicVar");
		System.out.println(publicField.get(obj));
		
		Method publicMethod = classObj.getMethod("publicMethod");
		publicMethod.invoke(obj);
		
		//accessing private members`
		Field privateField = classObj.getDeclaredField("privateVar");
		privateField.setAccessible(true);
		System.out.println(privateField.get(obj));
		
		Method privateMethod = classObj.getDeclaredMethod("privateMethod");
		privateMethod.setAccessible(true);
		privateMethod.invoke(obj);
	}
}
class TestClass{
	public String publicVar = "public var";
	private String privateVar = "private var";
	
	public void publicMethod() {
		System.out.println("public method");
	}
	
	private void privateMethod() {
		System.out.println("private method");
	}
}
