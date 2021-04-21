package shopping_hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateSessionUtility;

public class UserDAOImpl implements UserDAO, Cloneable {

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

	synchronized public static UserDAOImpl getInstance() {
		if (instance == null)
			instance = new UserDAOImpl();
		return instance.createClone();
	}

	@Override
	public UserDTO getUser(Integer userId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		UserDTO user = (UserDTO) session.get(UserDTO.class, userId);
		return user;
	}

	@Override
	public List<UserDTO> getAllUser() throws Exception{
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("from user");
		List list = query.list();

		Iterator<UserDTO> iter = list.iterator();
		List<UserDTO> result = new ArrayList();
		while (iter.hasNext()) {
			UserDTO temp = (UserDTO) iter.next();
			result.add(temp);
		}
		return result;
	}
	
	@Override
	public int createUser(UserDTO user) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		session.save(user);

		Query query = session.createQuery("select u.username from user u where u.userId=:id");
		query.setParameter("id", user.getUserId());

		List list = query.list();
		HibernateSessionUtility.closeSession(null);
		return list.size();
	}

	@Override
	public int updateUser(UserDTO user) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("update user set username=:name, password=:pass, flag=:f where userId=:id");

		query.setParameter("name", user.getUsername());
		query.setParameter("pass", user.getPassword());
		query.setParameter("f", user.getFlag());
		query.setParameter("id", user.getUserId());

		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteUser(UserDTO user) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from user where userId=:id");
		query.setParameter("id", user.getUserId());
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteUser(Integer userId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from user where userId=:id");
		query.setParameter("id", userId);
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

}
