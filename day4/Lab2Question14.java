package day4;

class Student{
	String name;
	int rollNo;
}

class Exam extends Student{
	int m1, m2, m3;
}

class Result extends Exam{
	int totalMarks;
	
	Result(String name, int rollNo, int m1, int m2, int m3){
		this.name = name;
		this.rollNo = rollNo;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
	
	void calculateTotalMarks() {
		this.totalMarks = this.m1 + this.m2 + this.m3;
		System.out.println("Name: "+this.name+" Roll.No: "+this.rollNo+" total: "+this.totalMarks);
	}
	
}
public class Lab2Question14 {
 public static void main(String[] args) {
	Result res = new Result("Sibi", 10, 60, 90, 60);
	res.calculateTotalMarks();
}
}
