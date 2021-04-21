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

public class InvoiceTransDAOImpl implements InvoiceTransDAO, Cloneable {
	private static InvoiceTransDAOImpl instance;

	private InvoiceTransDAOImpl() {}

	private InvoiceTransDAOImpl createClone() {
		InvoiceTransDAOImpl obj = null;
		try {
			obj = (InvoiceTransDAOImpl) super.clone();
		} catch (Exception e) {
		}
		return obj;
	}
	
	synchronized public static InvoiceTransDAOImpl getInstance() {
		if (instance == null)
			instance = new InvoiceTransDAOImpl();
		return instance.createClone();
	}

	@Override
	public InvoiceTransDTO getInvoice(Integer invoiceId, Integer itemId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		InvoiceTransDTO invoiceTransDTO = (InvoiceTransDTO) session.get(InvoiceTransDTO.class, new TransactionCompKey(invoiceId, itemId));
		return invoiceTransDTO;
	}

	@Override
	public List<InvoiceTransDTO> getAllInvoiceTrans() throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("from invoicetrans");
	
		Iterator<InvoiceTransDTO> iter = query.list().iterator();
		List<InvoiceTransDTO> transactions = new ArrayList<>();
		
		while(iter.hasNext()) {
			transactions.add(iter.next());
		}
		HibernateSessionUtility.closeSession(null);
		return transactions;
	}

	@Override
	public List<ItemDTO> getItemsInInvoice(Integer invoiceId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertInvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		session.save(invoiceTrans);
		
		Query query = session.createQuery("from invoicetrans i where i.compkey.invoiceId=:invId and i.compkey.itemId=:itemId");
		query.setParameter("invId", invoiceTrans.getCompkey().getInvoiceId());
		query.setParameter("itemId", invoiceTrans.getCompkey().getItemId());
		
		List list = query.list();
		HibernateSessionUtility.closeSession(null);
		return list.size();
	}

	@Override
	public int updateIvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("update invoicetrans set qty=:qty where invoiceId=:invId and itemId=:itemId");
		query.setParameter("qty", invoiceTrans.getQty());
		query.setParameter("invId", invoiceTrans.getCompkey().getInvoiceId());
		query.setParameter("itemId", invoiceTrans.getCompkey().getItemId());
		
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteInvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from invoicetrans where invoiceId=:invId and itemid=:itemId");
		query.setParameter("invId", invoiceTrans.getCompkey().getInvoiceId());
		query.setParameter("itemId", invoiceTrans.getCompkey().getItemId());
		
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteInvoiceTrans(Integer invoiceId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from invoicetrans where invoiceId=:id");
		query.setParameter("id", invoiceId);
		
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

}
