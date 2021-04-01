package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO, Cloneable {

	private Connection connection;
	private static UserDAOImpl instance;

	private UserDAOImpl() {
	}

	private UserDAOImpl createClone() {
		UserDAOImpl obj = null;
		try {
			obj = (UserDAOImpl) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	private UserDAOImpl setConnection(Connection connection) {
		this.connection = connection;
		return this;
	}

	synchronized public static UserDAOImpl getInstance(Connection connection) {
		if (instance == null)
			instance = new UserDAOImpl();
		return instance.createClone().setConnection(connection);
	}

	@Override
	public UserDTO getUser(Integer userId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("select * from user where userid = ?");
		st.setInt(1, userId);

		ResultSet res = st.executeQuery();
		if (res.first()) {
			UserDTO user = UserDTO.getUserDTO();
			user.setUserId(res.getInt("userid"));
			user.setFlag(res.getInt("flag"));
			user.setPassword(res.getString("password"));
			user.setUsername(res.getString("username"));

			st.close();
			res.close();
			return user;
		} else {
			st.close();
			res.close();
			System.out.println("No user found for id:  " + userId);
			return null;
		}
	}

	@Override
	public int createUser(UserDTO user) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("insert into user values (?, ?, ?, ?)");
		st.setInt(1, user.getUserId());
		st.setString(2, user.getUsername());
		st.setString(3, user.getPassword());
		st.setInt(4, user.getFlag());

		int rowsAffected = st.executeUpdate();
		return rowsAffected;
	}

	@Override
	public int updateUser(UserDTO user) throws Exception {
		PreparedStatement st = this.connection
				.prepareStatement("update user set username = ?, password = ?, flag = ? where userid = ?");
		st.setString(1, user.getUsername());
		st.setString(2, user.getPassword());
		st.setInt(3, user.getFlag());
		st.setInt(4, user.getUserId());

		int rowsAffected = st.executeUpdate();
		return rowsAffected;
	}

	@Override
	public int deleteUser(UserDTO user) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from user where userid = ?");
		st.setInt(1, user.getUserId());

		int rowsAffected = st.executeUpdate();
		return rowsAffected;
	}

	@Override
	public int deleteUser(Integer userId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from user where userid = ?");
		st.setInt(1, userId);

		int rowsAffected = st.executeUpdate();
		return rowsAffected;
	}

}
