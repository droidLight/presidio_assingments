package day13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
	
	public static void main(String[] args) {
		
		Map<Employee, String> map = new TreeMap<Employee, String>((o1, o2)->{return o1.compareTo(o2);});
		Map<Employee, String> mapTwo = new TreeMap<Employee, String>();
		
		map.put(new Employee(123), "first");
		map.put(new Employee(456), "second");
		map.put(new Employee(789), "third");
		map.put(new Employee(600), "fourth");
		
		Set<Map.Entry<Employee, String>> entrySet = map.entrySet();
		for(Map.Entry<Employee, String> entry : entrySet) {
			System.out.println("Key: "+entry.getKey()+"\tValue: "+entry.getValue());
		}
		System.out.println("=====================");
		mapTwo.put(new Employee(123), "first");
		mapTwo.put(new Employee(456), "second");
		mapTwo.put(new Employee(789), "third");
		mapTwo.put(new Employee(600), "fourth");
		
		Set<Map.Entry<Employee, String>> entrySetTwo = mapTwo.entrySet();
		for(Map.Entry<Employee, String> entry : entrySetTwo) {
			System.out.println("Key: "+entry.getKey()+"\tValue: "+entry.getValue());
		}
	}
}

class Employee implements Comparable<Employee>{

	Integer eid;
	Employee(int id){
		this.eid = Integer.valueOf(id);
	}
	
	@Override
	public int compareTo(Employee o) {
		return this.eid.compareTo(o.eid);
	}
	
	@Override
	public String toString() {
		return ""+this.eid;
	}
}