package onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="address")
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String city;
	private String street;
	
	@ManyToOne
	@JoinColumn(name="employee_eid")
	private Employee employee;
	
	public final int getAid() {
		return aid;
	}
	public final void setAid(int aid) {
		this.aid = aid;
	}
	
	public final String getCity() {
		return city;
	}
	public final void setCity(String city) {
		this.city = city;
	}
	
	public final String getStreet() {
		return street;
	}
	public final void setStreet(String street) {
		this.street = street;
	}
	
	public final Employee getEmp() {
		return employee;
	}
	public final void setEmp(Employee emp) {
		this.employee = emp;
	}
}
