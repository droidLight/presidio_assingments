package day19;

import java.io.Serializable;

public class UserDTO implements Serializable, Cloneable {

	private String username, password;
	private int userId, flag;
	
	private static UserDTO instance;

	private UserDTO() {
	}

	private UserDTO getCloneUserDTO() {
		try {
			return (UserDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	synchronized public static UserDTO getUserDTO() {
		if (instance == null) {
			instance = new UserDTO();
		}
		return instance.getCloneUserDTO();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (flag != other.flag)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void clearData() {
		this.username = null; 
		this.password = null;
		this.userId = 0; 
		this.flag = 0;
	}

}
