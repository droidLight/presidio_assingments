package daolayer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements Cloneable, UserDAO {

	Connection connection;
	private static UserDAOImpl instance;

	private UserDAOImpl() {
	}

	private UserDAOImpl getClone() {
		UserDAOImpl obj = null;
		try {
			obj = (UserDAOImpl) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	public static UserDAOImpl getInstance(Connection connection) {
		if (instance == null)
			instance = new UserDAOImpl();
		return instance.getClone().setConnection(connection);
	}

	private UserDAOImpl setConnection(Connection connection) {
		this.connection = connection;
		return this;
	}

	@Override
	public int createUser(String name, String password, int uid) throws Exception {
		PreparedStatement newUser = this.connection.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?)");
		newUser.setInt(1, uid);
		newUser.setString(2, name);
		newUser.setString(3, password);
		newUser.setInt(4, 0);
		int row = newUser.executeUpdate();
		this.connection.commit();
		return row;
	}

	@Override
	public int updateFlag(String name, String password, int flag) throws Exception {
		PreparedStatement updateFlag = this.connection
				.prepareStatement("UPDATE user set flag = ? WHERE username = ? AND password = ?");
		updateFlag.setInt(1, flag);
		updateFlag.setString(2, name);
		updateFlag.setString(3, password);

		int row = updateFlag.executeUpdate();
		this.connection.commit();
		return row;
	}

	@Override
	public UserDTO userExists(String name, String password) throws Exception {
		PreparedStatement getUser = this.connection.prepareStatement(
				"SELECT * FROM user WHERE username = ? AND password = ?", ResultSet.TYPE_SCROLL_INSENSITIVE);

		getUser.setString(1, name);
		getUser.setString(2, password);
		ResultSet res = getUser.executeQuery();

		if (res.next()) {
			UserDTO user = UserDTO.getUserDTO();
			user.setUid(res.getInt("userid"));
			user.setName(res.getString("username"));
			user.setPassword(res.getString("password"));
			user.setFlag(res.getInt("flag"));
			return user;
		} else {
			return null;
		}

	}

}
