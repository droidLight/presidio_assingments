package day9;

public class StackInterface {
	public static void main(String[] args) {
		
		MyStackInterface fixedStack = new DynamicStack(10);
		fixedStack.push(10);
		fixedStack.push(20);
		fixedStack.push(30);
		System.out.println(fixedStack.pop());
		System.out.println(fixedStack.pop());
		System.out.println(fixedStack.pop());
		System.out.println(fixedStack.pop());
		
	}
}


class DynamicStack implements MyStackInterface{
	private int maxCapacity;
	private int[] stack;
	private int top;
	
	public DynamicStack(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		stack = new int[this.maxCapacity];
		top = -1;
	}
	
	@Override
	public void push(int data) {
		if(top < this.maxCapacity) {
			this.stack[++top] = data;			
		}else {
			System.out.println("stack full");
		}
	}

	@Override
	public int pop() {
		if(top >= 0) {
			return this.stack[top--];
		}else {
			System.out.println("stack empty");
			return -999;
		}
				
	}
	
}

class FixedStack implements MyStackInterface{
	private int maxCapacity = 10;
	private int[] stack;
	private int top;
	public FixedStack() {		
		top = -1;
	}
	
	@Override
	public void push(int data) {
		if(top < this.maxCapacity) {
			this.stack[++top] = data;			
		}else {
			System.out.println("stack full");
		}
	}

	@Override
	public int pop() {
		if(top >= 0) {
			return this.stack[top--];
		}else {
			System.out.println("stack empty");
			return -999;
		}
				
	}
	
}

interface MyStackInterface{
	public void push(int data);
	public int pop();
}