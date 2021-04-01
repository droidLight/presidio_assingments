package day16;

import java.rmi.Naming;

public class RmiClient {
	
	public static void main(String[] args) throws Exception{
		
		Stock stock = (Stock) Naming.lookup("rmi://localhost:1099/rmiservice/stockService");
		System.out.println(stock.getStockPrice("ITC"));
	}
}
