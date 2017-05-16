package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ScoreDao;
import db.HibernateSessionFactory;
import entity.Score;
@Repository
public class ScoreService implements ScoreDao {
	
	//ScoreService service=new ScoreService();
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
    //添加记录
	public boolean add(Score score) {
		Transaction tx=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(score);
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
	//删除记录
	public boolean delete(int scid) {
		Transaction tx=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Score s=(Score) session.get(Score.class, scid);
			session.delete(s);
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
	//修改记录
	public boolean update(Score score) {
		Transaction tx=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.update(score);
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
	//通过id查询记录
	@SuppressWarnings("unchecked")
	public List<Score> queryById(int scid) {
		Transaction tx=null;
		List<Score> list=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			String hql=" from Score s where s.scid=:scid";
			list=session.createQuery(hql).setInteger("scid", scid).list();
			tx.commit();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

}
