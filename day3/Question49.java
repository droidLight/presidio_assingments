package day3;
import java.math.*;

public class Question49 {
	public static void main(String argv[]) {
		int iRand;
		double iRandDouble;
		//iRand = Math.random(); //cannot cast double to int. typecase=> iRand = (int) Math.random()
		iRandDouble = Math.random(); 
		System.out.println(iRandDouble);
	}
}
