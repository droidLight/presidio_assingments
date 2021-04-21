package utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtility {
	
	private HibernateSessionUtility() {}
	
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Transaction transaction;
	
	static {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();		
	}
	
	synchronized public static Session getSession() {
		try {
			Session session = threadLocal.get();
			if(session == null) {
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				threadLocal.set(session);
			}
			return session;
		}catch(Exception e) {
			System.out.println("MyUtility, getSession: "+e);
			return null;
		}
		
	}
	
	synchronized public static void closeSession(Exception e) {
		Session session = threadLocal.get();
		if(session != null) {
			if(e == null) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			session.close();
			threadLocal.remove();
		}		
	}
}
