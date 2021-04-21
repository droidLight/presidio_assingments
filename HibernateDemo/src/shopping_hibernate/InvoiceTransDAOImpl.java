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

//	@Override
//	public InvoiceTransDTO getInvoice(Integer invoiceId, Integer itemId) throws Exception {
//		Session session = HibernateSessionUtility.getSession();
//		InvoiceTransDTO invoiceTransDTO = (InvoiceTransDTO) session.get(InvoiceTransDTO.class, new TransactionCompKey(invoiceId, itemId));
//		return invoiceTransDTO;
//	}

	@Override
	public InvoiceTransDTO getTransaction(Integer transactionId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		InvoiceTransDTO invoiceTransDTO = (InvoiceTransDTO) session.get(InvoiceTransDTO.class, transactionId);
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
	public List<InvoiceTransDTO> getTransactionInInvoice(Integer invoiceId) throws Exception{
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("from invoicetrans where invoiceId=:id");
		query.setParameter("id", invoiceId);
		
		List<InvoiceTransDTO> result = new ArrayList<>();
		List list = query.list();
		HibernateSessionUtility.closeSession(null);
		Iterator<InvoiceTransDTO> iter = list.iterator();
		while(iter.hasNext()) {
			result.add(iter.next());
		}
		return result;
	}

	@Override
	public int insertInvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		session.save(invoiceTrans);
		HibernateSessionUtility.closeSession(null);
		return 1;
	}

	@Override
	public int updateIvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("update invoicetrans set itemId=:item, qty=:qty where transactionId=:id");
		query.setParameter("qty", invoiceTrans.getQty());
		query.setParameter("item", invoiceTrans.getItemId());
		query.setParameter("id", invoiceTrans.getTransactionId());
		
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteInvoiceTrans(InvoiceTransDTO invoiceTrans) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from invoicetrans where transactionId=:id");
		query.setParameter("id", invoiceTrans.getTransactionId());
		
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
