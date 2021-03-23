package day12;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
	
	public static void main(String[] args) {
		String[] arr = {"padala","meghana","kalpana","kanpur","megha","raghul","raghul","mohan","raghul","meghana"};
		
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		int total = 0;
		
		for(int i = 0; i < arr.length; i+=2) {			
			total += forkJoinPool.invoke(new MyTask(arr, i, i+2));			
		}
		System.out.println("Count of raghul: "+total);
	}
}

class MyTask extends RecursiveTask<Integer>{
	String[] arr;
	int start, end;
	
	MyTask(String[] arr, int start, int end){
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		int count = 0;
		for(int i = start; i < end; i++) {
			if(this.arr[i].equalsIgnoreCase("raghul")) {
				count++;
			}
		}
		return count;
	}
		
}
