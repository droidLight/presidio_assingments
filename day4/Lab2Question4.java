package day4;

class IntegerStack{
	private int top;
	private int[] arr;
	
	public IntegerStack(int n) {
		top = -1;
		arr = new int[n];
	}
	
	public void push(int x) {
		top++;
		arr[top] = x;
	}
	
	public int pop() {
		return arr[top--];
	}
	
}

public class Lab2Question4 {
	public static void main(String[] args) {
		
		IntegerStack stack = new IntegerStack(10);
		stack.push(10);
		stack.push(8);
		stack.push(7);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
