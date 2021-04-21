package manytomany;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="training")
@Table(name="training")
public class Training {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
	private String tname;
	private Date startDate;
	
	@ManyToMany(mappedBy="trainings")
	private Set<Student> students;
	
	public  int getTid() {
		return tid;
	}
	public  void setTid(int tid) {
		this.tid = tid;
	}
	public  String getTname() {
		return tname;
	}
	public  void setTname(String tname) {
		this.tname = tname;
	}
	public  Date getStartDate() {
		return startDate;
	}
	public  void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public  Set<Student> getStudents() {
		return students;
	}
	public  void setStudents(Set<Student> students) {
		this.students = students;
	}
}
