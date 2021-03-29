package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSaveDemo {
	
	public static void main(String[] args) throws Exception{
		
		ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("employee.dat"));
		
		Employee emp = new Employee();
		emp.setSalary(100000);
		oos.writeObject(emp);
		
		emp.setSalary(200000);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"));
		Employee empOne = (Employee)ois.readObject();
		
		System.out.println("Saved object: "+empOne.getSalary());
		System.out.println("Old object: "+emp.getSalary());
	}
}


class Employee implements Serializable{
	
	private int salary;
	
	public int getSalary() {
		return this.salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
}