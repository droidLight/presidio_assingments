package onetomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "employee")
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String ename;
	private float esal;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Address> addresses;

	public final int getEid() {
		return eid;
	}

	public final void setEid(int eid) {
		this.eid = eid;
	}

	public final String getEname() {
		return ename;
	}

	public final void setEname(String ename) {
		this.ename = ename;
	}

	public final float getEsal() {
		return esal;
	}

	public final void setEsal(float esal) {
		this.esal = esal;
	}

	public final Set<Address> getAddresses() {
		return addresses;
	}

	public final void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}
