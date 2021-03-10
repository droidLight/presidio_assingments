package day3;

public class Question30 {
	
	public static void main(String args[]) {
		Question30 obj = new Question30();
		obj.amethod();
	}
	public void amethod() {
		InnerClass obj = new InnerClass();
		InnerClassTwo objTwo = new InnerClassTwo();
		InnerClassThree objThree = new InnerClassThree();
	}
	
	 private class InnerClass{
		 InnerClass(){
			 System.out.println("InnerClass");
		 }
	 }
	 
	 public class InnerClassTwo{
		 InnerClassTwo(){
			 System.out.println("InnerClassTwo");
		 }
	 }
	 
	 static class InnerClassThree{
		 InnerClassThree(){
			 System.out.println("InnerCLassThree");
		 }
	 }
}
