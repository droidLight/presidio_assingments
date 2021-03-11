package day4;

public class Question21 {

	static int checkDaysOfMonth(String month, String yearStr) {

		month = month.toUpperCase();
		int year = Integer.valueOf(yearStr);
		boolean isLeapYear = (year % 4 == 0);

		int days = -1;

		switch (month) {
		case "JANUARY":
			days = 31;
			break;
		case "FEBRUARY":
			days = isLeapYear ? 29 : 28;
			break;
		case "MARCH":
			days = 31;
			break;
		case "MAY":
			days = 31;
			break;
		case "JULY":
			days = 31;
			break;
		case "AUGUST":
			days = 31;
			break;
		case "OCTOBER":
			days = 31;
			break;
		case "DECEMBER":
			days = 31;
			break;
		default:
			days = 30;
		}
		return days;
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("Days: "+checkDaysOfMonth(args[0], args[1]));
		} else {
			System.out.println("No parameter passed");
		}
	}
}
