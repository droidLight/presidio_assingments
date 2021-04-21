package manytomany;

import java.util.Date;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateSessionUtility;

import java.util.HashSet;

public class WriteClient {
	
	public static void main(String[] args) {
		
		Student student = new Student();
		student.setSname("sibi");
		student.setMarks(650);
		
		Training classOne = new Training();
		classOne.setTname("Java");
		classOne.setStartDate(new Date());
		
		Training classTwo = new Training();
		classTwo.setTname("Angular");
		classTwo.setStartDate(new Date());
		
		Set<Training> trainingSet = new HashSet();
		trainingSet.add(classOne);
		trainingSet.add(classTwo);
		
		student.setTrainings(trainingSet);
		
		Session session = HibernateSessionUtility.getSession();
		session.save(student);
		
		//not needed if cascade is "all"
		session.save(classOne);
		session.save(classTwo);
		
		HibernateSessionUtility.closeSession(null);
	}
}
