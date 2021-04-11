package daolayer;

public interface UserDAO {
	public int createUser(String name, String password, int uid) throws Exception;
	public int updateFlag(String name, String password, int flag) throws Exception;
	public UserDTO userExists(String name, String password) throws Exception;
}
