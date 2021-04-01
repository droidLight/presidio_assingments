package day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatementDemo {
	
	public static void main(String[] args) throws Exception{
		
		Connection connection = DBUtility.getConnection();
		PreparedStatement st = connection.prepareStatement("select *  from users where uid=?");
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter uid: ");
			int uid = s.nextInt();
			
			st.setInt(1, uid);
			ResultSet res = st.executeQuery();
			
			int cols = res.getMetaData().getColumnCount();
			while(res.next()) {
				for(int i = 1; i <= cols; i++) {
					System.out.print(res.getString(i)+"\t");
				}
				System.out.println("");
			}
			
		}
	}
}
