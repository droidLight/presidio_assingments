package day4;

import java.util.Scanner;

public class Question13 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter number of students: ");
		int students = s.nextInt();
		
		System.out.println("Enter number of subjects: ");
		int subjects = s.nextInt();
		
		int[][] marks = new int[students][subjects];
		
		//get marks
		for(int i = 0; i < marks.length; i++) {
			System.out.println("Enter marks for student_"+(i+1));
			for(int j = 0; j < marks[i].length; j++) {
				marks[i][j] = s.nextInt();
			}
		}
		
		//calculate total
		for(int i = 0; i < marks.length; i++) {
			int totalMarks = 0;
			for(int j = 0; j < marks[i].length; j++) {
				totalMarks += marks[i][j];
			}
			System.out.println("Total marks for student_ "+(i+1)+" is: "+totalMarks);
		}
		s.close();
	}
}
