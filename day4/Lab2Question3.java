package day4;

import java.util.Date;

class Employee {
	protected Date dateOfJoining;

	Employee() {
		this.dateOfJoining = new Date();
		System.out.println("emp class");
	}
}

class SalesPerson extends Employee {
	SalesPerson() {
		System.out.println(this.dateOfJoining);
		System.out.println("sales person class");
	}
}

class Worker extends Employee {
	Worker() {
		System.out.println(this.dateOfJoining);
		System.out.println("worker class");
	}
}

class SalesManager extends SalesPerson {
	SalesManager() {
		System.out.println(this.dateOfJoining);
		System.out.println("sales manager class");
	}
}

class SalesTerritoryManager extends SalesManager {
	public SalesTerritoryManager() {
		System.out.println(this.dateOfJoining);
		System.out.println("sales territory manager class");
	}
}

public class Lab2Question3 {
	public static void main(String[] args) {
		SalesPerson obj = new SalesPerson();
		System.out.println(obj.dateOfJoining);
	}
}
