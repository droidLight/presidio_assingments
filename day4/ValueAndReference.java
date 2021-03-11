package day4;

public class ValueAndReference {
	
	public static void main(String[] args) {
		DataClass obj = new DataClass(10);
		System.out.println("original: "+obj.value);
		
		new PassByValue().setValue(obj.value);
		System.out.println("pass by value: "+obj.value);
		
		new PassByRef().setValue(obj);
		System.out.println("pass by reference: "+obj.value);
	}
}

class DataClass{
	int value;
	DataClass(int value){
		this.value = value;
	}
}

class PassByValue{
	
	void setValue(int i) {
		i = i * 100;
	}
}


class PassByRef{
	void setValue(DataClass obj) {
		obj.value = obj.value * 100;
	}
}