package servicelayer;

public interface LoginService {
	boolean userExists(String userName, String password) throws Exception;

	boolean checkFlag(String uname, String password) throws Exception;

	int setFlag(String userName, String password, int flag) throws Exception;

	int registerUser(int uid, String userName, String password, int flag) throws Exception;
}
