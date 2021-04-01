package day18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetDemo {
	
	public static void main(String[] args) throws Exception{
		
		Connection connection = DBUtility.getConnection();
		
		Statement st = connection.createStatement();
		
		ResultSet res = st.executeQuery("select * from users");
		
		ResultSetMetaData resMeta = res.getMetaData();
		System.out.println(resMeta.getColumnCount());
		for(int i = 1; i  <= resMeta.getColumnCount(); i++) {
			System.out.print(resMeta.getColumnName(i)+"\t");
		}
		System.out.println("\n-----------------------------");
		while(res.next()) {
			for(int i = 1; i <=resMeta.getColumnCount(); i++) {
				System.out.print(res.getString(i)+"\t");
			}
			System.out.println("");
		}
	}
}
