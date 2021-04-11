package servicelayer;

import daolayer.UserDAO;
import daolayer.UserDTO;

public class LoginServiceImpl implements LoginService, Cloneable{

	
	private static LoginServiceImpl instance;
	private UserDAO userDAO;
	
	private LoginServiceImpl() {}
	
	private LoginServiceImpl getClone() {
		try {
			return (LoginServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private LoginServiceImpl setDAO(UserDAO userDAO) {
		this.userDAO=userDAO;
		return this;
	}
	
	synchronized public static LoginServiceImpl getLoginService(UserDAO userDAO) {
		if(instance==null) {
			instance=new LoginServiceImpl();
		}
		return instance.getClone().setDAO(userDAO);
	}
	
	
	@Override
	public boolean userExists(String userName, String password) throws Exception {
		UserDTO user = userDAO.userExists(userName, password);
		return user != null;
	}

	@Override
	public boolean checkFlag(String userName, String password) throws Exception{
		UserDTO user = userDAO.userExists(userName, password);
		if(user != null) {
			return user.getFlag() == 0;
		}else {
			return false;
		}
	}

	@Override
	public int setFlag(String userName, String password, int flag) throws Exception{
		int rowsAffected = userDAO.updateFlag(userName, password, flag);
		return rowsAffected;
	}

	@Override
	public int registerUser(int uid, String userName, String password, int flag) throws Exception{
		int rowsAffected = userDAO.createUser(userName, password, uid);
		return rowsAffected;
	}

}
