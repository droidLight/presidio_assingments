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

public class InvoiceDAOImpl implements InvoiceDAO, Cloneable{
	private static InvoiceDAOImpl instance;
	
	private InvoiceDAOImpl() {}
	
	private InvoiceDAOImpl createClone() {
		InvoiceDAOImpl obj = null;
		try {
			obj = (InvoiceDAOImpl) super.clone();
		}catch(Exception e) {}
		return obj;
	}
	
	synchronized public static InvoiceDAOImpl getInstance() {
		if(instance == null)
			instance = new InvoiceDAOImpl();
		return instance.createClone();
	}
	
	@Override
	public InvoiceDTO getInvoice(Integer invoiceId) throws Exception {		
		Session session = HibernateSessionUtility.getSession();
		InvoiceDTO invoice = (InvoiceDTO) session.get(InvoiceDTO.class, invoiceId);
		HibernateSessionUtility.closeSession(null);
		return invoice;
	}

	@Override
	public List<InvoiceDTO> getAllInvoice() throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("from invoice");
	
		Iterator<InvoiceDTO> iter = query.list().iterator();
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		
		while(iter.hasNext()) {
			invoiceList.add(iter.next());
		}
		HibernateSessionUtility.closeSession(null);
		return invoiceList;
	}

	@Override
	public List<InvoiceDTO> getCustomerInvoice(Integer customerId) throws Exception {

		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("from invoice i where i.customerId=:id");
		query.setParameter("id", customerId);
		
		Iterator<InvoiceDTO> iter = query.list().iterator();
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		while(iter.hasNext()) {
			invoiceList.add(iter.next());
		}
		HibernateSessionUtility.closeSession(null);
		return invoiceList;
	}

	@Override
	public int insertInvoice(InvoiceDTO invoice) throws Exception {

		Session session = HibernateSessionUtility.getSession();
		session.save(invoice);
		
		Query query = session.createQuery("from invoice i where i.invoiceId=:id");
		query.setParameter("id", invoice.getInvoiceId());
		List list = query.list();
		HibernateSessionUtility.closeSession(null);
		return list.size();
	}

	@Override
	public int updateInvoice(InvoiceDTO invoice) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("update invoice set customerId=:cusId, invoiceDate=:invDate where invoiceId=:invId");
		query.setParameter("invId", invoice.getInvoiceId());
		query.setParameter("invDate", invoice.getInvoiceDate());
		query.setParameter("cusId", invoice.getCustomerId());
		
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteInvoice(InvoiceDTO invoice) throws Exception {		
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from invoice where invoiceId=:id");
		query.setParameter("id", invoice.getInvoiceId());
		
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

	@Override
	public int deleteInvoiceById(Integer invoiceId) throws Exception {
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("delete from invoice where invoiceId=:id");
		query.setParameter("id", invoiceId);
		
		int rowsUpdated = query.executeUpdate();
		HibernateSessionUtility.closeSession(null);
		return rowsUpdated;
	}

}
