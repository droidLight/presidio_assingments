package day6;
import java.util.Scanner;

public class BadFanDemo {
	public static void main(String[] args) {
		BadFan badFan	=new BadFan();
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter to pull the chain...");
			scan.next();
			badFan.pull();
		}
	}
}



class BadFan{
	int state=0;
	public void pull() {
		switch(state) {
		case 0:{
			System.out.println("switch on state....");
			state=1;
			break;
		}
		case 1:{
			System.out.println("medium speed state....");
			state=2;
			break;
		}
		case 2:{
			System.out.println("high speed state.....");
			state=3;
			break;
		}
		case 3:{
			System.out.println("switch off state....");
			state=0;
			break;
		}
		}
	}
}
