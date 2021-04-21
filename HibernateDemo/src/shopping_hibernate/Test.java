package shopping_hibernate;

import java.sql.Connection;
import java.sql.Savepoint;
import java.util.List;
import java.sql.Date;

public class Test {
	public static void main(String[] args){
		
		UserDAO dao = UserDAOImpl.getInstance();
		UserDTO user = UserDTO.getUserDTO();
		user.setUsername("sibi");
		user.setFlag(0);
		user.setPassword("password");
		
		UserDTO user2 = UserDTO.getUserDTO();
		user2.setUsername("ajith");
		user2.setFlag(0);
		user2.setPassword("password2");
		
		try {
			System.out.println("created: "+dao.createUser(user));
			System.out.println("created: "+dao.createUser(user2));
			
			user2.setFlag(1);			
			System.out.println("update: "+dao.updateUser(user2));
			
			for(UserDTO temp : dao.getAllUser()) {
				System.out.println(temp.getUserId()+"\t"+temp.getUsername()+"\t"+temp.getPassword()+"\t"+temp.getFlag());
			}
			
			dao.deleteUser(user);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println("end");
	}
}
