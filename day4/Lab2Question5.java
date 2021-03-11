package day4;

class UserClass{
	static int userCount = 0;
	public UserClass() {
		userCount++;
	}
}

public class Lab2Question5 {
	public static void main(String[] args) {
		UserClass objOne = new UserClass();
		UserClass objTwo = new UserClass();
		UserClass objThree = new UserClass();
		UserClass objFour =new UserClass();
		
		System.out.println(objOne.userCount);
	}
}
