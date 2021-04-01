package day18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class ScrollSensitiveDemo {
	
	public static void main(String[] args) throws Exception{
		Connection connection = DBUtility.getConnection();
		
		Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet res = st.executeQuery("select * from users");
		ResultSetMetaData resMeta = res.getMetaData();
		
		while(res.next()) {
			for(int i = 1; i <=resMeta.getColumnCount(); i++) {
				System.out.print(res.getString(i)+"\t");
			}
			System.out.println("");
		}
		
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		System.out.println("After update");
		res.beforeFirst();
		
		while(res.next()) {
			for(int i = 1; i <=resMeta.getColumnCount(); i++) {
				System.out.print(res.getString(i)+"\t");
			}
			System.out.println("");
		}
	}
}
