package day6;

public class MethodReferenceDemo {

	public MethodReferenceDemo() {}
	
	public void newMethod() {
		System.out.println("From myMethod");
	}
	
	public String newMethodTwo(String str) {
		return "from newMethod: "+str;
	}
	
	static int newMethodThree(int x) {
		return x * 100;
	}
	
	public static void main(String[] args) {
		
		NewInterface ref = new MethodReferenceDemo()::newMethod;
		ref.newMethod();
		
		NewInterfaceTwo refTwo = new MethodReferenceDemo()::newMethodTwo;		
		System.out.println(refTwo.newMethodTwo("test"));
		
		NewInterfaceThree refThree = MethodReferenceDemo::newMethodThree;
		System.out.println("refThree: "+refThree.newMethodThree(8));
	}
}
@FunctionalInterface
interface NewInterface{
	public void newMethod();	
}

@FunctionalInterface
interface NewInterfaceTwo{
	String newMethodTwo(String str);
}

@FunctionalInterface
interface NewInterfaceThree{
	int newMethodThree(int x);
}