package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import db.HibernateSessionFactory;
import entity.User;
@Repository
public class UserService implements UserDao {
	
	private SessionFactory sessionFactory; 
	//����һ��sessionFactory  
    //����Ҫʹ��sessoinFactory��ʱ��Spring�ὫsessionFactoryע�����  
   @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    } 
    protected Session getSession() {  
        //�ӵ�ǰ�̻߳�ȡsession�����û���򴴽�һ���µ�session  
        return sessionFactory.getCurrentSession();  
    }  
	public boolean login(User user) {
		Transaction tx=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			String hql=" from User where username=? and password=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List list=query.list();
			tx.commit();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return  false;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	public boolean reg(String username,String password) {
		Transaction tx=null;
		try{
			Session session=getSession();
			//Session session=HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			User user=new User(username,password);
			session.save(user);
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
}
