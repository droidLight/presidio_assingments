package day18;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class CallableStatementDemo {
	
	public static void main(String[] args) throws Exception{
		
		Connection connection = DBUtility.getConnection();
		
		//calling procesure without parameter
//		CallableStatement st = connection.prepareCall("{call proc1()}");
//		
//		int rows = st.executeUpdate();
//		System.out.println("Rows affected: "+rows);
		
		//calling procedure with parameter
//		CallableStatement st = connection.prepareCall("{call proc2(?,  ?)}");
//		st.setString(1, "abc");
//		st.setInt(2, 0);
//		
//		int rows = st.executeUpdate();
//		System.out.println("Rows affected: "+rows);
		
		//getting values from procedures
		CallableStatement st = connection.prepareCall("{call proc3(?, ?)}");
		st.setString(1, "abc");
		st.registerOutParameter(2, Types.INTEGER);
		
		st.executeUpdate();
		System.out.println("Flag :"+st.getInt(2));
		
		DBUtility.closeConnection(null, null);
	}
}
