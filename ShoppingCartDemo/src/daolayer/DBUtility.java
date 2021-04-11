package daolayer;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class DBUtility {
	private DBUtility() {
		// TODO Auto-generated constructor stub
	}

	private static ThreadLocal<Connection> tlocal=new ThreadLocal<>();
	private static Connection con;
	
	synchronized public static Connection getConnection(String driver, String url, String username, String password) {
		con=tlocal.get();
		if(con==null) {			
			try {
				//Class.forName(driver);
				//con=DriverManager.getConnection(url,username,password);
				Class.forName("com.mysql.cj.jdbc.Driver");
				con =  DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "root");
				con.setAutoCommit(false);
				tlocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	synchronized public static void closeConnection(Exception e,Savepoint sp) {
		con=tlocal.get();
		if(con!=null) {
			try {
				if(e==null) {
					con.commit();//manual commit
				}
				else {
					if(sp==null) {
						con.rollback();
					}
					else {
						con.rollback(sp);
						con.commit();
					}
				}
			con.close();
			tlocal.remove();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}
}
