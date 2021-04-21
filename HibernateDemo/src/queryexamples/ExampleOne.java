package queryexamples;

import java.util.List;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateSessionUtility;
import manytomany.*;
import onetomany.*;

public class ExampleOne {

	public static void main(String[] args) {
		ExampleOne obj = new ExampleOne();

		//obj.sampleOne();
		//obj.sampleTwo();
		//obj.sampleThree();
		//obj.sampleFour();
		obj.sampleFive();
		//obj.sampleSix();
		//obj.sampleSeven();
		//obj.sampleEight();
	}

	public void sampleOne() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Query query = session.createQuery("from Student");

			List list = query.list();

			Iterator<Student> iter = list.iterator();
			while (iter.hasNext()) {
				Student obj = (Student) iter.next();
				System.out.println(obj.getSname());
				for (Training temp : obj.getTrainings()) {
					System.out.println(temp.getTname() + "\t" + temp.getStartDate());
				}
			}
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {

		}
	}

	public void sampleTwo() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Query query = session.createQuery("select student.sname from Student student");

			List list = query.list();
			Iterator<String> iter = list.iterator();
			while (iter.hasNext()) {
				String name = iter.next();
				System.out.println(name);
			}
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleOne: " + e);
		}

	}

	public void sampleThree() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Query query = session.createQuery("select student.sname, student.marks from Student student");

			List list = query.list();
			Iterator<Object[]> iter = list.iterator();

			while (iter.hasNext()) {
				Object[] temp = iter.next();
				for (Object obj : temp) {
					System.out.println(obj);
				}
			}
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleTwo: " + e);
		}
	}

	public void sampleFour() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Query query = session.createQuery("from Student student where student.marks > 100");
			List list = query.list();

			Iterator<Student> iter = list.iterator();
			while (iter.hasNext()) {
				Student obj = (Student) iter.next();
				System.out.println(obj.getSname());
				for (Training temp : obj.getTrainings()) {
					System.out.println(temp.getTname() + "\t" + temp.getStartDate());
				}
			}
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleThree: " + e);
		}
	}

	public void sampleFive() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Query query = session
					.createQuery("select e.ename, a.city from employee e join e.addresses a with a.city=:c");
			query.setParameter("c", "chennai");

			Iterator<Object[]> obj = query.iterate();
			while (obj.hasNext()) {
				Object o[] = obj.next();
				System.out.println("eName: " + o[0] + "\tcity: " + o[1]);
			}

		} catch (Exception e) {
			System.out.println("sampleFive: " + e);
		}
	}

	public void sampleSix() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Query query = session.createQuery("select e.name, a.city from Employee e left join e.addresses a with a.city=:c");
			query.setParameter("c", "chennai");

			Iterator<Object[]> obj = query.iterate();
			while (obj.hasNext()) {
				Object o[] = obj.next();
				System.out.println("eName: " + o[0] + "\tcity: " + o[1]);
			}

		} catch (Exception e) {
			System.out.println("sampleFive: " + e);
		}
	}
	
	public void sampleSeven() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Query query = session.createQuery("update Employee set esal = esal + 10000");
			int rowsUpdated =query.executeUpdate();
			System.out.println("Rows updated: "+rowsUpdated);
			HibernateSessionUtility.closeSession(null);
		}catch(Exception e) {
			System.out.println("sampleSeven: "+e);
		}
	}
	
	public void sampleEight() {
		
		try {
			Session session = HibernateSessionUtility.getSession();
			Query query = session.createQuery("insert into BackupEmployee(eid, ename, esal) select e.eid, e.ename, e.esal from Employee e");
			int objAdded = query.executeUpdate();
			System.out.println("Objects added: "+objAdded);
			HibernateSessionUtility.closeSession(null);
		}catch(Exception e) {
			System.out.println("sampleEight: "+e);
		}
	}
}
