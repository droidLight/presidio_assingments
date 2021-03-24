package day13;
import java.util.*;

public class Question4 {

	private Map<String, Integer> accountTotals = new HashMap<>();
	private int retirementFund;

	public static void main(String[] args) {
		Question4 obj = new Question4();
		obj.setBalance("sibi", 100000);
		System.out.println(obj.getBalance("sibi"));
	}
		
	public int getBalance(String accountName) {
		Integer total = (Integer) accountTotals.get(accountName);
		if (total == null)
			total = Integer.valueOf(0);
		return total.intValue();
	}

	public void setBalance(String accountName, int amount) {
		accountTotals.put(accountName, Integer.valueOf(amount));
	}
}