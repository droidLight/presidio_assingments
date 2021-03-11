package day4;

public class VariablesDemo {

	public static void main(String args[]) {
		new ClassOne();
		new ClassOne();
		new ClassOne();
	}
}

class ClassOne{
	static ClassVarClass classVariable = new ClassVarClass();
	InstanceVarClass instanceVariable = new InstanceVarClass();
	
	public ClassOne() {
		
	}
}

class InstanceVarClass{
	public InstanceVarClass() {
		System.out.println("InstanceVarClass");
	}
}

class ClassVarClass{
	public ClassVarClass() {
		System.out.println("ClassVarClass");
	}
}