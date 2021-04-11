package daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTransDAOImpl implements InvoiceTransDAO, Cloneable {
	private Connection connection;
	private static InvoiceTransDAOImpl instance;

	private InvoiceTransDAOImpl() {
	}

	private InvoiceTransDAOImpl createClone() {
		InvoiceTransDAOImpl obj = null;
		try {
			obj = (InvoiceTransDAOImpl) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	private InvoiceTransDAOImpl setConnection(Connection connection) {
		this.connection = connection;
		return this;
	}

	synchronized public static InvoiceTransDAOImpl getInstance(Connection connection) {
		if (instance == null)
			instance = new InvoiceTransDAOImpl();
		return instance.createClone().setConnection(connection);
	}

	@Override
	public InvoiceTransDTO getInvoice(Integer invoiceId, Integer itemId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement(
				"select * from invoicetrans where invid = ? AND itemid = ?", ResultSet.TYPE_SCROLL_SENSITIVE);
		st.setInt(1, invoiceId);
		st.setInt(2, itemId);
		ResultSet res = st.executeQuery();
		if (res.first()) {
			InvoiceTransDTO invoiceTrans = InvoiceTransDTO.getInvoiceTransDTO();

			invoiceTrans.setInvoiceId(res.getInt("invid"));
			invoiceTrans.setItemId(res.getInt("itemid"));
			invoiceTrans.setQty(res.getInt("qty"));
			st.close();
			res.close();
			return invoiceTrans;
		} else {
			st.close();
			res.close();
			System.out.println("No invoice transaction found for invoiceId: " + invoiceId + " and item id: " + itemId);
			return null;
		}
	}

	@Override
	public List<InvoiceTransDTO> getAllInvoiceTrans() throws Exception {
		List<InvoiceTransDTO> invoiceList = new ArrayList<>();
		Statement st = this.connection.createStatement();
		ResultSet res = st.executeQuery("select * from invoicetrans");

		while (res.next()) {
			InvoiceTransDTO invoiceTrans = InvoiceTransDTO.getInvoiceTransDTO();
			invoiceTrans.setInvoiceId(res.getInt("invid"));
			invoiceTrans.setItemId(res.getInt("itemid"));
			invoiceTrans.setQty(res.getInt("qty"));
			invoiceList.add(invoiceTrans);
		}
		res.close();
		st.close();
		return invoiceList;
	}

	@Override
	public List<ItemDTO> getItemsInInvoice(Integer invoiceId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertInvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {		
		PreparedStatement st = this.connection.prepareStatement("insert into invoicetrans values(?, ?, ?)");
		st.setInt(1, invoiceTrans.getInvoiceId());
		st.setInt(2, invoiceTrans.getItemId());
		st.setInt(3, invoiceTrans.getQty());

		int rowsAffected = st.executeUpdate();
		st.close();
		this.connection.commit();
		return rowsAffected;
	}

	@Override
	public int updateIvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {
		PreparedStatement st = this.connection
				.prepareStatement("update invoicetrans set qty = ? where invid = ? and itemid = ?");
		st.setInt(1, invoiceTrans.getQty());
		st.setInt(2, invoiceTrans.getInvoiceId());
		st.setInt(3, invoiceTrans.getItemId());

		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int deleteInvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {
		PreparedStatement st = this.connection
				.prepareStatement("delete from invoicetrans where invid = ? and itemid = ?");
		st.setInt(1, invoiceTrans.getInvoiceId());
		st.setInt(2, invoiceTrans.getItemId());

		int rowsAffected = st.executeUpdate();
		st.close();
		return rowsAffected;
	}

	@Override
	public int deleteInvoiceTrans(Integer invoiceId) throws Exception {
		PreparedStatement st = this.connection.prepareStatement("delete from invoicetrans where invid = ?");
		st.setInt(1, invoiceId);

		int rowAffected = st.executeUpdate();
		st.close();
		return rowAffected;
	}

}
