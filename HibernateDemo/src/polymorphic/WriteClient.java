package polymorphic;

import org.hibernate.Session;

import utility.HibernateSessionUtility;

public class WriteClient {
	
	public static void main(String[] args) {
		ShoeFactory shoeFactory= new ShoeFactory();
		shoeFactory.setShoeName("shoe name");
		
		BataFactory bataFactory = new BataFactory();
		bataFactory.setBataName("Bata name");
		
		LakhaniFactory lakhaniFactory = new LakhaniFactory();
		lakhaniFactory.setLakhaniName("lakhani name");
		
		Session session = HibernateSessionUtility.getSession();
		
		session.save(shoeFactory);
		session.save(bataFactory);
		session.save(lakhaniFactory);
		
		HibernateSessionUtility.closeSession(null);
	}
}
