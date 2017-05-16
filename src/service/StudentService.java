package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.StudentDao;
//import db.HibernateSessionFactory;
import entity.Score;
import entity.Student;
@Repository
public class StudentService implements StudentDao {
	private ScoreService scoreService;
	@Autowired
	public void setScoreService(ScoreService scoreService){
		this.scoreService=scoreService;
	}
	private SessionFactory sessionFactory; 
	//定义一个sessionFactory  
    //当需要使用sessoinFactory的时候，Spring会将sessionFactory注入进来  
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }    
    protected Session getSession() {  
        //从当前线程获取session，如果没有则创建一个新的session  
        return sessionFactory.getCurrentSession();  
    }  
    //删除学生
//	public boolean delete(int sid) {
//		StudentService stuService=new StudentService();
//	Student s=stuService.queryById(sid);
//		Transaction tx=null;
//		try{
//			Session session=getSession();
//			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
//			//Student s=stuService.queryById(sid);
//			tx=session.beginTransaction();
//			session.delete(s);
//			tx.commit();
//			return true;
//		}catch(Exception ex){
//			ex.printStackTrace();
//			return false;
//		}finally{
//			if(tx!=null){
//				tx=null;
//			}
//		}
//	}
    public boolean delete(Student student){
    	Transaction tx=null;
    	try{
    		Session session=getSession();
    		tx=session.beginTransaction();
    		session.delete(student);
    		tx.commit();
    		return true;
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}finally{
    		if(tx!=null){
    			tx=null;
    		}
    	}
    }
	//修改学生
	public boolean update(Student s) {
		Transaction tx=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			String hql="update Student s set s.sname=:sname,s.gender=:gender,s.address=:address where s.sid=:sid";
			Query query=session.createQuery(hql);
			query.setString("sname", s.getSname());
			query.setString("gender", s.getGender());
			query.setString("address", s.getAddress());
			query.setInteger("sid", s.getSid());
			query.executeUpdate();
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@SuppressWarnings("unchecked")
	//查询学生
	public List<Student> query() {
		Transaction tx=null;
		List<Student> list=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			String hql=" from Student";
			list=session.createQuery(hql).list();
			tx.commit();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
		return null;
	}
	//添加学生
	public boolean add(int sid, String sname, String gender, String address, int scid) {
		List<Score> list=scoreService.queryById(scid);
		Transaction tx=null;
		try{
			System.out.println(scid);
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			//List<Score> list=service.queryById(scid);
			//事务嵌套问题
			if(list==null){
				System.out.println("here");
			}
			Student student=new Student(sid,sname,gender,address,list.get(0));
			session.save(student);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	//按学号查找学生
	public Student queryById(int sid) {
		Transaction tx=null;
		Student s=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			s=(Student) session.get(Student.class, sid);
			tx.commit();
			return s;
		}catch(Exception ex){
			ex.printStackTrace();
			return s;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

}
