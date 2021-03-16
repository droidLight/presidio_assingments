package day6;
import java.util.Scanner;

public class GoodFanDemo {
	public static void main(String args[]) {
		
		GoodFan goodFan = new GoodFan();
		Scanner s = new Scanner(System.in);
				
		while(true) {
			System.out.println("pull fan");
			s.next();
			goodFan.pull();
		}
	}
}

class GoodFan{
	private State currentState;	
	
	public GoodFan() {
		this.currentState = new OffState();
	}
	
	public void pull() {
		currentState.pull(this);
	}
	
	public void setState(State state) {
		this.currentState = state;
	}
}


abstract class State{
	public abstract void pull(GoodFan fan);	
}

class FirstState extends State{

	@Override
	public void pull(GoodFan fan) {
		System.out.println("switching to state 2");
		fan.setState(new SecondState());
	}	
}

class SecondState extends State{

	@Override
	public void pull(GoodFan fan) {
		System.out.println("switching to state 3");
		fan.setState(new ThirdState());
	}
	
}
class ThirdState extends State{

	@Override
	public void pull(GoodFan fan) {
		System.out.println("switching to off state");
		fan.setState(new OffState());
	}
	
	
}
class OffState extends State{

	@Override
	public void pull(GoodFan fan) {
		System.out.println("switching to state 1");
		fan.setState(new FirstState());
	}
	
	
}

