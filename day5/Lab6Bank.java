package day5;

class Bank {

	String nameOfDepositor, accountType;
	int accountNumber, balanceAmount;

	Bank(String nameOfDepositor, String accountType, int accountNumber, int balanceAmount) {
		this.nameOfDepositor = nameOfDepositor;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.balanceAmount = balanceAmount;
	}

	void intialValue() {
		this.accountNumber = 12345678;
		this.nameOfDepositor = "None";
		this.accountType = "Savings";
		this.balanceAmount = 0;
	}

	void deposit(int amount) {
		if (this.balanceAmount < 10000000) {
			this.balanceAmount += amount;
		}
	}

	void printDetails() {
		System.out.println("Name: " + this.accountNumber + " Balance: " + this.balanceAmount);
	}

}

public class Lab6Bank {
	public static void main(String[] args) {
		
		Bank bank = new Bank("Sibi", "Savings", 123456789, 400000);
		bank.printDetails();
		bank.deposit(300000);
		bank.printDetails();
	}
}
