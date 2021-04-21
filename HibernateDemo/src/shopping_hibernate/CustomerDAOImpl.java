package shopping_hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateSessionUtility;

public class CustomerDAOImpl implements CustomerDAO, Cloneable {

	private static CustomerDAOImpl instance;

	private CustomerDAOImpl() {
	}

	private CustomerDAOImpl createClone() {
		CustomerDAOImpl obj = null;
		try {
			obj = (CustomerDAOImpl) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	synchronized public static CustomerDAOImpl getInstance() {
		if (instance == null)
			instance = new CustomerDAOImpl();
		return instance.createClone();
	}

	@Override
	public CustomerDTO getCustomerById(Integer customerId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		CustomerDTO customer = (CustomerDTO) session.get(CustomerDTO.class, customerId);
		return customer;
	}

	@Override
	public List<CustomerDTO> getAllCustomer() throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("from customer");
		List list = query.list();

		Iterator<CustomerDTO> iter = list.iterator();
		List<CustomerDTO> result = new ArrayList();
		while (iter.hasNext()) {
			CustomerDTO temp = (CustomerDTO) iter.next();
			result.add(temp);
		}
		return result;
	}

	@Override
	public int createCustomer(CustomerDTO customer) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		session.save(customer);

		Query query = session.createQuery("select c.customerName from customer c where c.customerId=:id");
		query.setParameter("id", customer.getCustomerId());

		List list = query.list();
		HibernateSessionUtility.closeSession(null);
		return list.size();
	}

	@Override
	public int updateCustomer(CustomerDTO customer) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery(
				"update customer set customerName=:name, phone=:ph, address=:adr, accountDetails=:acc where customerId=:id");

		query.setParameter("name", customer.getCustomerName());
		query.setParameter("ph", customer.getPhone());
		query.setParameter("adr", customer.getAddress());
		query.setParameter("acc", customer.getAccountDetails());
		query.setParameter("id", customer.getCustomerId());

		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteCustomer(CustomerDTO customer) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from customer where customerId=:id");
		query.setParameter("id", customer.getCustomerId());
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteCustomer(Integer customerId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from customer where customerId=:id");
		
		query.setParameter("id", customerId);
		int rowsUpdated = query.executeUpdate();
		
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

}
