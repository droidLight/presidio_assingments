package shopping_hibernate;

import java.util.List;

public interface CustomerDAO {
	
	public CustomerDTO getCustomerById(Integer customerId) throws Exception;
	public List<CustomerDTO> getAllCustomer() throws Exception;
	public int createCustomer(CustomerDTO customer) throws Exception;
	public int updateCustomer(CustomerDTO customer) throws Exception;
	public int deleteCustomer(CustomerDTO customer) throws Exception;
	public int deleteCustomer(Integer customerId) throws Exception;
}
