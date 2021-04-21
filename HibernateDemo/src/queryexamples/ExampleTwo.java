package queryexamples;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import onetomany.Address;
import onetomany.Employee;
import utility.HibernateSessionUtility;

public class ExampleTwo {

	public static void main(String[] args) {
		ExampleTwo obj = new ExampleTwo();
		obj.sampleThree();
	}

	public void display(Criteria criteria) {
		List list = criteria.list();
		Iterator<Employee> iter = list.iterator();
		while (iter.hasNext()) {
			Employee emp = iter.next();
			System.out.println(emp.getEid() + "\t" + emp.getEname() + "\t" + emp.getEsal());
		}

	}

	public void sampleOne() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Criteria criteria = session.createCriteria(Employee.class);

			display(criteria);
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleOne: " + e);
		}
	}

	public void sampleTwo() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.addOrder(Order.asc("ename"));

			// descending order
			// criteria.addOrder(Order.desc("ename"));

			display(criteria);
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleTwo: " + e);
		}
	}

	public void sampleThree() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Criteria criteria = session.createCriteria(Employee.class);

			criteria.add(Property.forName("ename").eq("sibi"));

			Employee emp = (Employee) criteria.uniqueResult();
			System.out.println(emp.getEid() + "\t" + emp.getEname() + "\t" + emp.getEsal());
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleThree: " + e);
		}
	}

	public void sampleFour() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Criteria criteria = session.createCriteria(Address.class);

			criteria.add(Property.forName("employee.ename").eq("sibi"));
			List list = criteria.list();
			Iterator<Address> iter = list.iterator();

			while (iter.hasNext()) {
				Address temp = iter.next();
				System.out.println("street: " + temp.getStreet() + "\t" + "city: " + temp.getCity());
			}
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleFour: " + e);
		}
	}

	public void sampleFive() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Criteria criteria = session.createCriteria(Employee.class);
			Integer[] range = new Integer[] { Integer.valueOf(100000), Integer.valueOf(700000) };
			criteria.add(Property.forName("esal").in(range));

			display(criteria);
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleFive: " + e);
		}
	}

	public void sampleSix() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Criteria criteria = session.createCriteria(Employee.class);

			criteria.add(Restrictions.like("ename", "S%").ignoreCase());
			criteria.add(Restrictions.gt("esal", Integer.valueOf(500000)));

			display(criteria);
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {
			System.out.println("sampleSix: " + e);
		}
	}

	public void sampleSeven() {
		try {
			Session session = HibernateSessionUtility.getSession();
			Criteria criteria = session.createCriteria(Employee.class);

			Criterion criterionOne = Restrictions.like("ename", "A%");
			Criterion criterionTwo = Restrictions.gt("esal", Integer.valueOf(900000));
			criteria.add(Restrictions.or(criterionOne, criterionTwo));

			display(criteria);
			HibernateSessionUtility.closeSession(null);
		} catch (Exception e) {

		}
	}

	public void sampleEight() {
		Session session = HibernateSessionUtility.getSession();
		DetachedCriteria dc = DetachedCriteria.forClass(Employee.class);
		
		Criterion criterionOne = Restrictions.like("ename", "A%");
		Criterion criterionTwo = Restrictions.gt("esal", Integer.valueOf(900000));
		dc.add(Restrictions.or(criterionOne, criterionTwo));
		
		
		Criteria criteria = dc.getExecutableCriteria(session);
		display(criteria);
	}
}
