package day12;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class GarbageCollectionDemo {
	
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.out.println("Before object creation: "+r.freeMemory());
		
		TestClass obj = new TestClass();		
		System.out.println("After object creation: "+r.freeMemory());
		
		WeakReference weak = new WeakReference(obj); //will remove the object during garbage collection
		
		SoftReference soft = new SoftReference(obj);//can retrieve after gargabe collection
		
		r.gc();
	}
}

class TestClass{
	String data = "some data";
	String memory;
	
	TestClass(){
		memory="";
		for(int i = 0; i < 1000; i++) {
			memory = memory + new String(i+"");
		}
	}
	
	@Override
	public void finalize() throws Throwable{
		System.out.println("Finalized called");
	}
}