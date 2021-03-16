package day6;

public class InnerClassDemo {

}


abstract class Cola{
	public abstract void makeCola();
}

class Pepsi{
	private Cola cola;
	
	public void sellPepsiCola() {
		cola.makeCola();
		System.out.println("Pepsi sell cola");
	}
}

class Kallimark{}