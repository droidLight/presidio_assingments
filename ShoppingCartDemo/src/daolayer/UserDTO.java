package daolayer;

import java.io.Serializable;

public class UserDTO implements Cloneable, Serializable{
	
	private String name, password;	
	private int uid, flag;
	
	private static UserDTO instance;
	
	private UserDTO() {}
	
	private UserDTO createClone() {
		UserDTO obj = null;
		try {
			obj = (UserDTO) super.clone();
		}catch(Exception e) {
			
		}
		return obj;
	}
	public static synchronized UserDTO getUserDTO() {
		if(instance == null)
			instance = new UserDTO();
		return instance.createClone();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + uid;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

}
