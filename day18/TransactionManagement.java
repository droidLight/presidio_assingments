package day18;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionManagement {

	public static void main(String[] args) {

		Connection connection = DBUtility.getConnection();
		Savepoint savepoint = null;
		
		try {

			Statement statement = connection.createStatement();

//			statement.executeUpdate(
//					"create table users (uid int(5), name varchar(25), password varchar(30), flag int(0))");

			int rowsAffected = statement.executeUpdate("insert into users values (1, 'abc', 'password', 0)");
			System.out.println("Rows affected...: " + rowsAffected);
			
			
			rowsAffected = statement.executeUpdate("insert into users values (2, 'def', 'password2', 1)");
			System.out.println("Rows affected...: " + rowsAffected);
			savepoint = connection.setSavepoint();
			
			rowsAffected = statement.executeUpdate("insert into users values (3, 'ghi', 'pass3', 0)");
			System.out.println("Rows affected...: " + rowsAffected);
			
			DBUtility.closeConnection(null, null);
		} catch (Exception e) {
			DBUtility.closeConnection(e, savepoint);
			System.out.println(e);
		}
	}
}
