package day6;

public class LambdaDemo {

	public static void main(String[] args) {
		
		MyInterfaceOne interfaceOne = ()->{
			System.out.println("From myMethod");
		};
		
		interfaceOne.myMethod();
		
		MyInterfaceTwo interfaceTwo = (n)->{
			System.out.println("in mymethodTwo");
			return n * 1000;
		};
		
		System.out.println(interfaceTwo.myMethodTwo(10));
	}
}

@FunctionalInterface
interface MyInterfaceOne{
	public void myMethod();
}

interface MyInterfaceTwo{
	public int myMethodTwo(int x);
}