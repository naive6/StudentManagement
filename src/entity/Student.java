 package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int sid;
	private String sname;
	private String gender;
	private String address;
	private Score score;
	public Student() {
		
	}
	
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", address=" + address + "]";
	}
	public Student(int sid, String sname, String gender, String address,Score score) {
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.address = address;
		this.score=score;
	}
	public Student(int sid, String sname, String gender, String address) {
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.address = address;
	}
	@Id
	@GeneratedValue(generator="sid")
	@GenericGenerator(name="sid",strategy="assigned")
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="scid",unique=true)
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
}
