package day6;

public class SingletonPatternDemo {

	public static void main(String[] args) throws Exception {

		MySingletonClass objOne = MySingletonClass.createObject();
		objOne.data = 1;
		System.out.println("objOne: " + objOne.data);

		MySingletonClass objTwo = MySingletonClass.createObject();
		objTwo.data = 2;
		System.out.println("objTwo: " + objTwo.data);

		System.out.println("objOne: " + objOne.data);
	}
}

class MySingletonClass {
	public int data;
	private static MySingletonClass instance;

	public static MySingletonClass createObject() throws Exception {
		if (instance == null)
			instance = new MySingletonClass();
		return instance;
	}

}