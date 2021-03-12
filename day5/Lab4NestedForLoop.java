package day5;

public class Lab4NestedForLoop {
	public static void main(String[] args) {
		
		int current = 1;
		for(int i = 0; i < 5; i++) {
			
			for(int j = 0; j < i; j++) {
				System.out.print(current+"\t");
				current++;
			}
			System.out.println("");
		}
		
		current = 0;
		boolean flag= true;
		for(int i = 0; i < 5; i++) {
			
			for(int j = 0; j < i; j++) {
				if(i == 4 && flag) {
					flag=false;
					System.out.print("\t");
				}else {
					System.out.print(current+"\t");
				}
								
			}
			System.out.println("");
		}

	}
}
