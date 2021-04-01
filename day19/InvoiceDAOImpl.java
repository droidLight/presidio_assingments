package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAOImpl implements InvoiceDAO, Cloneable{
	private Connection connection;
	private static InvoiceDAOImpl instance;
	
	private InvoiceDAOImpl() {}
	
	private InvoiceDAOImpl createClone() {
		InvoiceDAOImpl obj = null;
		try {
			obj = (InvoiceDAOImpl) super.clone();
		}catch(Exception e) {}
		return obj;
	}
	private InvoiceDAOImpl setConnection(Connection connection) {
		this.connection = connection;
		return this;		
	}
	synchronized public static InvoiceDAOImpl getInstance(Connection connection) {
		if(instance == null)
			instance = new InvoiceDAOImpl();
		return instance.createClone().setConnection(connection);
	}
	
	@Override
	public InvoiceDTO getInvoice(Integer invoiceId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("select * from invoicemaster where invid = ?",ResultSet.TYPE_SCROLL_SENSITIVE);
		st.setInt(1, invoiceId);
		ResultSet res = st.executeQuery();
		if(res.first()) {
			InvoiceDTO invoice = InvoiceDTO.getInvoiceDTO();
			invoice.setCustomerId(res.getInt("customerid"));
			invoice.setInvoiceDate(res.getDate("invdate"));
			invoice.setInvoiceId(res.getInt("invid"));
			
			st.close();
			res.close();
			return invoice;
		}else {
			st.close();
			res.close();
			System.out.println("No invoice found for invoiceId: "+invoiceId);
			return null;
		}
	}

	@Override
	public List<InvoiceDTO> getAllInvoice() throws Exception {
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		Statement st = this.connection.createStatement();
		ResultSet res = st.executeQuery("select * from invoicemaster");
		
		while(res.next()) {
			InvoiceDTO invoice = InvoiceDTO.getInvoiceDTO();
			invoice.setCustomerId(res.getInt("customerid"));
			invoice.setInvoiceDate(res.getDate("invdate"));
			invoice.setInvoiceId(res.getInt("invid"));
			invoiceList.add(invoice);
		}
		res.close();
		st.close();
		return invoiceList;
	}

	@Override
	public List<InvoiceDTO> getCustomerInvoice(Integer customerId) throws Exception {
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		PreparedStatement st = this.connection.prepareStatement("select * from invoicemaster where customerid = ?");
		st.setInt(1, customerId);
		ResultSet res = st.executeQuery();
		
		while(res.next()) {
			InvoiceDTO invoice = InvoiceDTO.getInvoiceDTO();
			invoice.setCustomerId(res.getInt("customerid"));
			invoice.setInvoiceDate(res.getDate("invdate"));
			invoice.setInvoiceId(res.getInt("invid"));
			invoiceList.add(invoice);
		}
		res.close();
		st.close();
		return invoiceList;
	}

	@Override
	public int insertInvoice(InvoiceDTO invoice) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("insert into invoicemaster values(?, ?, ?)");
		st.setInt(1, invoice.getInvoiceId());
		st.setDate(2, invoice.getInvoiceDate());
		st.setInt(3, invoice.getCustomerId() );
		
		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int updateInvoice(InvoiceDTO invoice) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("update invoicemaster set invdate = ? customerid = ? where invid = ?");		
		st.setDate(1, invoice.getInvoiceDate());
		st.setInt(2, invoice.getCustomerId() );
		st.setInt(3, invoice.getInvoiceId());
		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int deleteInvoice(InvoiceDTO invoice) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from invoicemaster where invid = ?");
		st.setInt(0, invoice.getInvoiceId());
		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int deleteInvoiceById(Integer invoiceId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from invoicemaster where invid = ?");
		st.setInt(0, invoiceId);
		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

}
