package pojos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utility.HibernateSessionUtility;

public class ReadClient {
	
	public static void main(String[] args) {
		
		Session session = HibernateSessionUtility.getSession();
		
		Book book = (Book) session.get(Book.class, Integer.valueOf(3));
		
		System.out.println(book);
	}
}
