package onetomany;

import org.hibernate.Session;

import utility.HibernateSessionUtility;

public class ReadClient {
	
	public static void main(String[] args) {
		
		Session session = HibernateSessionUtility.getSession();
		
		Employee emp = (Employee) session.get(Employee.class, Integer.valueOf(1));
		
		System.out.println("Employee name: "+emp.getEname());
		for(Address adr : emp.getAddresses()) {
			System.out.println("street: "+adr.getStreet()+"\tcity: "+adr.getCity());
		}
		
		HibernateSessionUtility.closeSession(null);
	}
}
