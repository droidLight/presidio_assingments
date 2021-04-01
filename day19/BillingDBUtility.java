package day19;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class BillingDBUtility {
	private BillingDBUtility() {}

	private static String url, username, password;
	static {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("billingDB.properties"));
			String driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("userid");
			password = prop.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ThreadLocal<Connection> tlocal = new ThreadLocal<>();
	private static Connection con;

	synchronized public static Connection getConnection() {
		con = tlocal.get();
		if (con == null) {
			try {
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);
				tlocal.set(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	synchronized public static void closeConnection(Exception exception, Savepoint sp) {
		con = tlocal.get();
		if (con != null) {
			try {
				if (exception == null) {
					con.commit();
				} else {
					if (sp == null) {
						con.rollback();
						con.commit();
					} else {
						con.rollback(sp);
						con.commit();
					}
				}
				con.close();
				tlocal.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}