package day5;
import java.util.*;

public class Lab3Seasons {

	static String getSeason(String month) {
		month = month.toUpperCase();
		if (month.equals("JANUARY") || month.equals("DECEMBER")) {
			return "Winter";
		} else if (month.equals("FEBRUARY") || month.equals("MARCH")) {
			return "Spring";
		} else if (month.equals("APRIL") || month.equals("JUNE") || month.equals("MAY")) {
			return "Summer";
		} else if (month.equals("JULY") || month.equals("AUGUST") || month.equals("SEPTEMBER")
				|| month.equals("OCTOBER")) {
			return "Monsoon";
		} else {
			return "NAN";
		}

	}

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a month to find its season: ");
		String month = s.next();
		
		System.out.println("It is "+getSeason(month)+" during "+month);
	}
}
