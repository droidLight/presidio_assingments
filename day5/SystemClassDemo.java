package day5;

public class SystemClassDemo {
	public static void main(String[] args) {
		System.out.println("Java version: "+System.getProperty("java.version"));
		System.out.println("Java runtime: "+System.getProperty("java.runtime.version"));
		System.out.println("class path: "+System.getProperty("java.class.path"));
		System.out.println("class path: "+System.getProperty("java.vendor"));
		System.out.println("Java home: "+System.getProperty("java.home"));
	}
}
