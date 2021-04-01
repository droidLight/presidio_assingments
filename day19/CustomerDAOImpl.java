package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO, Cloneable{
	
	private Connection connection;
	private static CustomerDAOImpl instance;
	
	private CustomerDAOImpl() {}
	
	private CustomerDAOImpl createClone() {
		CustomerDAOImpl obj = null;
		try {
			obj = (CustomerDAOImpl) super.clone();
		}catch(Exception e) {}
		return obj;
	}
	private CustomerDAOImpl setConnection(Connection connection) {
		this.connection = connection;
		return this;		
	}
	
	synchronized public static CustomerDAOImpl getInstance(Connection connection) {
		if(instance == null)
			instance = new CustomerDAOImpl();
		return instance.createClone().setConnection(connection);
	}
	
	@Override
	public CustomerDTO getCustomerById(Integer customerId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("select * from customer where customerid = ?",ResultSet.TYPE_SCROLL_SENSITIVE);
		st.setInt(1, customerId);
		ResultSet res = st.executeQuery();
		if(res.first()) {
			CustomerDTO customer = CustomerDTO.getCustomerDTO();
			customer.setCustomerId(res.getInt("customerid"));
			customer.setPhone(res.getInt("phone"));
			customer.setAddress(res.getString("customeraddress"));
			customer.setCustomerName(res.getString("customername"));
			customer.setAccountDetails(res.getString("accountdetails"));
			st.close();
			res.close();
			return customer;
		}else {
			st.close();
			res.close();
			System.out.println("No customer found for customer id:  "+customerId);
			return null;
		}
	}

	@Override
	public List<CustomerDTO> getAllCustomer() throws Exception {
		List<CustomerDTO> customerList = new ArrayList<>();
		Statement st = this.connection.createStatement();
		ResultSet res = st.executeQuery("select * from customer");
		
		while(res.next()) {
			CustomerDTO customer = CustomerDTO.getCustomerDTO();
			customer.setCustomerId(res.getInt("customerid"));
			customer.setPhone(res.getInt("phone"));
			customer.setAddress(res.getString("customeraddress"));
			customer.setCustomerName(res.getString("customername"));
			customer.setAccountDetails(res.getString("accountdetails"));

			customerList.add(customer);
		}
		res.close();
		st.close();
		return customerList;
	}

	@Override
	public int createCustomer(CustomerDTO customer) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("insert into customer values(?, ?, ?, ?, ?)");
		st.setInt(1, customer.getCustomerId());
		st.setString(2, customer.getCustomerName());
		st.setString(3, customer.getAddress());
		st.setString(4, customer.getAccountDetails());
		st.setInt(5, customer.getPhone());
		
		int rowsAffected = st.executeUpdate();
		return rowsAffected;
	}

	@Override
	public int updateCustomer(CustomerDTO customer) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("update customer set phone = ?, customeraddress = ?, customername = ?, accountdetails = ? where customerid = ?");		
		st.setInt(1, customer.getPhone());
		st.setString(2, customer.getAddress());
		st.setString(3,customer.getCustomerName());
		st.setString(4, customer.getAccountDetails());
		st.setInt(5, customer.getCustomerId());
		
		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int deleteCustomer(CustomerDTO customer) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from customer where customerid = ?");
		st.setInt(1, customer.getCustomerId());
		
		int rowsAffected = st.executeUpdate();
		return rowsAffected;
	}

	@Override
	public int deleteCustomer(Integer customerId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from customer where customerid = ?");
		st.setInt(1, customerId);
		
		int rowsAffected = st.executeUpdate();
		return rowsAffected;
	}

}
