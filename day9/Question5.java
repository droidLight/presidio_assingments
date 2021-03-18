package day9;
import day9.question5.QuestionInterface;

public class Question5 {
	public static void main(String[] args) {
		TestClass obj = new TestClass();
		obj.methodOne("string parameter");
		System.out.println(obj.methodTwo(10));
		System.out.println(obj.methodThree("dogs"));
	}
}

class TestClass implements QuestionInterface{

	@Override
	public void methodOne(String str) {
		System.out.println("from methodOne str: "+str);
	}

	@Override
	public int methodTwo(int n) {
		return n* n;
	}

	@Override
	public String methodThree(String str) {
		return "from methodThree: "+str;
	}
	
}
