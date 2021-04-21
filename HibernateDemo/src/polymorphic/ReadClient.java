package polymorphic;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

import utility.HibernateSessionUtility;

public class ReadClient {
	
	public static void main(String[] args) {
		
		Session session = HibernateSessionUtility.getSession();
		Query query = session.createQuery("from ShoeFactory");
		
		List<ShoeFactory> factories = query.list();
		Visitor castLogic = new VisitorImpl();
		for(ShoeFactory shoeFactory : factories) {
			shoeFactory.visitor(castLogic);
		}
	}
}
