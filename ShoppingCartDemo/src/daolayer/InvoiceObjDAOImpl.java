package daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;

import models.Invoice;

public class InvoiceObjDAOImpl implements InvoiceObjDAO, Cloneable{
	
	private Connection connection;
	private static InvoiceObjDAOImpl instance;

	private InvoiceObjDAOImpl() {
	}

	private InvoiceObjDAOImpl createClone() {
		InvoiceObjDAOImpl obj = null;
		try {
			obj = (InvoiceObjDAOImpl) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}

	private InvoiceObjDAOImpl setConnection(Connection connection) {
		this.connection = connection;
		return this;
	}

	synchronized public static InvoiceObjDAOImpl getInstance(Connection connection) {
		if (instance == null)
			instance = new InvoiceObjDAOImpl();
		return instance.createClone().setConnection(connection);
	}

	
	@Override
	public Invoice getInvoiceById(Integer invId) throws Exception{
		 PreparedStatement st = this.connection.prepareStatement("SELECT * FROM invoiceobj WHERE invid=?", ResultSet.TYPE_SCROLL_INSENSITIVE);;		 
		 st.setInt(1, invId);
		 
		 ResultSet res = st.executeQuery();
		 if(res.next()) {
			 Blob invoiceBlob = res.getBlob("invoice");
			 ByteArrayInputStream bin = new ByteArrayInputStream(invoiceBlob.getBytes(1, (int) invoiceBlob.length()));
			 ObjectInputStream objIn = new ObjectInputStream(bin);
			 Invoice invoiceObj = (Invoice) objIn.readObject();
			 
			 return invoiceObj;
		 }else {
			 return null;
		 }
	}

	@Override
	public int insertInvoice(Invoice invoice) throws Exception {
		Integer invId =Integer.parseInt(invoice.getInvoiceId());
		
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(bOut);
		
		objOut.writeObject(invoice);
		objOut.flush();
		PreparedStatement st = this.connection.prepareStatement("INSERT INTO invoiceobj VALUES(?, ?)");
		st.setInt(1, invId);
		byte[] invoiceByte = bOut.toByteArray();
		ByteArrayInputStream bis = new ByteArrayInputStream(invoiceByte);
		st.setBinaryStream(2, bis, invoiceByte.length);
		objOut.close();
		bOut.close();
		
		int rowsAffected = st.executeUpdate();
		System.out.println("reached");
		this.connection.commit();
		return rowsAffected;
	}

	
}
