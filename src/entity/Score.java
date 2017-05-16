package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Score {
	private int scid;
	private int math;
	private int chinese;
	private int english;
	public Score(){
		
	}
	public Score( int math, int chinese, int english) {
		super();
		this.math = math;
		this.chinese = chinese;
		this.english = english;
	}
	
	public Score(int scid, int math, int chinese, int english) {
		this.scid=scid;
		this.math = math;
		this.chinese = chinese;
		this.english = english;
	}
	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	@Id
	@GeneratedValue
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
}
