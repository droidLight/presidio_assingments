package day4;

class SingletonClass{
	private static SingletonClass instance;
	
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		if(instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}
}
public class Lab2Question8 {
	public static void main(String[] args) {
		SingletonClass obj = SingletonClass.getInstance();
	}
}
