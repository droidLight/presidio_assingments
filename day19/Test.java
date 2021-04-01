package day19;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Date;

public class Test {
	public static void main(String[] args){
		Connection connection = BillingDBUtility.getConnection();

		CustomerDAO customerDAO = CustomerDAOImpl.getInstance(connection);		
		CustomerDTO customer = CustomerDTO.getCustomerDTO();
		customer.setAccountDetails("blah blah blah text");
		customer.setAddress("blah blah blah address");
		customer.setCustomerId(123);
		customer.setCustomerName("sibi");
		customer.setPhone(1234567890);
		
		InvoiceDAO invoiceDAO = InvoiceDAOImpl.getInstance(connection);		
		InvoiceDTO invoice = InvoiceDTO.getInvoiceDTO();
		invoice.setCustomerId(123);
		invoice.setInvoiceId(456);
		invoice.setInvoiceDate(new Date(12, 10, 1999));
		
		Savepoint save = null;
		try {
			//first transaction
			
			//customerDAO.createCustomer(customer);
			invoiceDAO.insertInvoice(invoice);
			save = connection.setSavepoint();

			//clearing data present in obj
			customer.clearData();
			
			//second transaction
			//assume it is failed
			throw new Exception();
			
//			BillingDBUtility.closeConnection(null, save);
		}catch(Exception e) {
			BillingDBUtility.closeConnection(e, save);
		}
		
		System.out.println("end");
	}
}
