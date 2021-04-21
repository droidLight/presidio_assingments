package compkey;

import org.hibernate.Session;

import utility.HibernateSessionUtility;

public class WriteClient {
	
	public static void main(String[] args) {
		
		CompKey key = new CompKey();
		key.setInvoiceId(123);
		key.setItemId(12);
		
		Transaction transaction = new Transaction();
		transaction.setCompkey(key);
		transaction.setQuant(100);
		
		Session session = HibernateSessionUtility.getSession();
		
		session.save(transaction);
		
		HibernateSessionUtility.closeSession(null);
	}
}
