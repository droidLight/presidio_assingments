package day18;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JDBCDemo {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			DatabaseConnection db = DatabaseConnection.getDatabase("./codaDB.properties");
			Connection con = db.getConnection();
			System.out.println("connected in thread 1");
			
			DatabaseConnection dbTwo = DatabaseConnection.getDatabase("./codaDB.properties");
			Connection conTwo = dbTwo.getConnection();
			System.out.println("connected again in thread 1");
		});
		
		es.execute(()->{
			DatabaseConnection db = DatabaseConnection.getDatabase("./codaDB.properties");
			Connection con = db.getConnection();
			System.out.println("connected in thread 2");			
		});
		
		es.shutdown();
	}
}


//not good, use DBUtility
class DatabaseConnection{
	
	private static DatabaseConnection instance;
	private Connection connection;
	private String url, userId, password;
	
	private DatabaseConnection() {
		System.out.println("Constructor called");
	}
	
	public static DatabaseConnection getDatabase(String path) {
		if(instance == null) 
			instance = new DatabaseConnection();
		
		return instance.setProperties(path);
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	private DatabaseConnection setProperties(String path) {
		try {
			Properties properties =new Properties();
			properties.load(new FileInputStream(path));
			
			if(this.url == null || this.password == null || this.userId == null) {
				this.url = properties.getProperty("url");
				this.userId = properties.getProperty("userid");
				this.password = properties.getProperty("password");
				
				this.connection = DriverManager.getConnection(this.url, this.userId, this.password);
				System.out.println("Created new connection");
			}else {
				System.out.println("using existing connection");
			}
			
			return this;
		}catch(Exception e) {}		
		return null;
	}
	
//	private DatabaseConnection createClone() {
//		DatabaseConnection obj = null;
//		try {
//			obj = (DatabaseConnection) super.clone();
//		}catch(Exception e) {}
//		return obj;
//	}
}