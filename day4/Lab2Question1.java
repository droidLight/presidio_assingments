package day4;

public class Lab2Question1 {
	
	public static void main(String[] args) {
		Data obj = new Data(10);
		System.out.println("original: "+obj.value);
		
		new PassByValueClass().setValue(obj.value);
		System.out.println("pass by value: "+obj.value);
		
		new PassByRefClass().setValue(obj);
		System.out.println("pass by reference: "+obj.value);
	}
}

class Data{
	int value;
	Data(int value){
		this.value = value;
	}
}

class PassByValueClass{
	
	void setValue(int i) {
		i = i * 100;
	}
}


class PassByRefClass{
	void setValue(Data obj) {
		obj.value = obj.value * 100;
	}
}