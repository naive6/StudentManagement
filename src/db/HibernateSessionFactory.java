package db;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {
	
	private static SessionFactory sessionFactory;
	private HibernateSessionFactory(){
		
	}
	//获得会话工厂，用来获得当前对话。
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			Configuration config=new Configuration().configure();
			ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory=config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	}
}

