package day4;
import java.util.Scanner;

public class Question5 {
	
	float calcAverage(int[] nums) {
		float average = 0f;
		int total = 0;
		
		for(int i : nums) {
			total += i;
		}
		average = (float)total / nums.length;
		return average;
	}
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		Question5 obj = new Question5();
		
		System.out.println("Enter n: ");
		int n = s.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter num_"+(i+1)+": ");
			nums[i] = s.nextInt();
		}
		System.out.println("Average: "+obj.calcAverage(nums));
		s.close();
	}
}
