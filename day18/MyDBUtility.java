package day18;

import java.sql.Connection;

public class MyDBUtility {
	
	private MyDBUtility(){}
	
	private Connection instance;
	private ThreadLocal<Connection> threadLocal = new ThreadLocal();
	
	public static Connection getConnection() {
		return null;
	}
}
