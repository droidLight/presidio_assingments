package compkey;

import org.hibernate.Session;

import utility.HibernateSessionUtility;

public class ReadClient {
	
	public static void main(String[] args) {
		
		CompKey key = new CompKey();
		key.setInvoiceId(123);
		key.setItemId(12);
		
		Session session = HibernateSessionUtility.getSession();
		Transaction trans = (Transaction) session.get(Transaction.class, key);
		
		System.out.println(trans.getCompkey().getInvoiceId()+"\t"+trans.getCompkey().getItemId()+"\t"+trans.getQuant());
	}
}
