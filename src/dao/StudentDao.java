package dao;

import java.util.List;

import entity.Student;

public interface StudentDao {
	public boolean add(int sid,String sname,String gender,String address,int scid);
	public boolean delete(Student student);
	public boolean update(Student s);
	public List<Student> query();
	public Student queryById(int sid);
}
