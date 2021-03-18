package day8;
import java.lang.reflect.*;

public class ReflectionDemo2 {
	
	public static void main(String[] args) throws Exception{
		//creating new object without new keyword
		DemoClass demo = (DemoClass) Class.forName("day8.DemoClass").getConstructor().newInstance();
		
		demo = (DemoClass) Class.forName("day8.DemoClass").getConstructor(String.class).newInstance("parameter from main");
		
		demo = (DemoClass) Class.forName("day8.DemoClass").getConstructor(int.class).newInstance(20);
		
		//public variables and methods
		System.out.println("");
		Field[] publicFields = demo.getClass().getFields();
		for(Field f : publicFields) {
			System.out.println(f.getName());
		}
		System.out.println("");
		
		Method publicMethod = demo.getClass().getMethod("publicMethodTwo", String.class, int.class);
		String result = (String) publicMethod.invoke(demo, "parameter", 10);
		System.out.println(result);
				
		//private method
		Method privateMethod = demo.getClass().getDeclaredMethod("privateMethod");
		privateMethod.setAccessible(true);
		privateMethod.invoke(demo);
		
		//from parent class
		//public method
		Method parentPublic = demo.getClass().getMethod("publicParentMethod");
		parentPublic.invoke(demo);
		
		//private method
		Method parentNonPublic = demo.getClass().getSuperclass().getDeclaredMethod("nonPublicParentMethod");
		parentNonPublic.setAccessible(true);
		parentNonPublic.invoke(demo);
	}
}

class DemoParent{
	public void publicParentMethod() {
		System.out.println("publicParentMethod called");
	}
	
	void nonPublicParentMethod() {
		System.out.println("nonPublicParentMethod called");
	}
}

class DemoClass extends DemoParent{
	
	public String varOne, varTwo, varThree;
	
	public DemoClass() {
		System.out.println("Default Constructor called");
	}
	
	public DemoClass(String str) {
		System.out.println("String parameter Constructor called...... "+str);
	}
	
	public DemoClass(int n) {
		System.out.println("int parameter Constructor called..... "+n);
	}
	
	public void publicMethod() {
		System.out.println("publicMethod called");
	}
	
	public String publicMethodTwo(String str, int i) {
		return "publicMethodTwo called.. str: "+str+" i: "+i;
	}
	
	private void privateMethod() {
		System.out.println("private method called");
	}
}