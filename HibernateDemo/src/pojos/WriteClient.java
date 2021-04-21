package pojos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utility.HibernateSessionUtility;

public class WriteClient {
	
	public static void main(String[] args) {
		
		Book book = new Book();
		book.setName("Intro to Angular");
		book.setAuthor("sohaib");
		book.setPrice(750);
		Comment comment = new Comment();
		comment.setCommentText("good book");
		book.setComment(comment);
		
		Session session = HibernateSessionUtility.getSession();
		
		session.save(book);
		HibernateSessionUtility.closeSession(null);
		
//		Configuration cfg = new Configuration().configure();
//		SessionFactory factory = cfg.buildSessionFactory();
//		
//		Session session = factory.openSession();
//		
//		session.save(book);
//		session.beginTransaction().commit();
	}
}
