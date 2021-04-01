package day19;

public interface UserDAO {
	
	public UserDTO getUser(Integer userId) throws Exception;
	public int createUser(UserDTO user) throws Exception;
	public int updateUser(UserDTO user) throws Exception;
	public int deleteUser(UserDTO user) throws Exception;
	public int deleteUser(Integer userId) throws Exception;
}
