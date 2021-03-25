package day14;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
	
	public static void main(String[] args) {
		
		Map<Employee, String> map = new WeakHashMap<Employee, String>();
		
		Employee emp1 = new Employee(100);
		Employee emp2 = new Employee(200);
		Employee emp3 = new Employee(300);
		
		map.put(emp1, "first");
		map.put(emp2, "second");
		map.put(emp3, "third");
		
		emp3 = null; //due to weak reference, the entry with key as emp3 is removed during garbage collection
		
		System.gc();
		Set<Map.Entry<Employee, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Employee, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getValue());
		}
	}
}

class Employee{

	Integer eid;
	Employee(int id){
		this.eid = Integer.valueOf(id);
	}
}