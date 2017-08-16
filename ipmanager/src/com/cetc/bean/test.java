package com.cetc.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cetc.dao.IpDao;
import com.cetc.dao.IpDaoImp;
import com.cetc.dao.UserDao;
import com.cetc.dao.UserDaoImp;

public class test {

	public static void main(String[] args) {
	Configuration configuration=new Configuration().configure();
	ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	Session session= sessionFactory.openSession();
	Transaction transaction=session.beginTransaction();
		
		
		 /*SessionFactory sessionFactory;
	   Session session;
	   Transaction transaction;
		
		//创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事物
        transaction = session.beginTransaction();
		*/
		
		
	 
		User user= new User();
		user.setName("张三");
		user.setTelephone("123456");
	  Ip ip = new Ip();
		ip.setIp("192.168.1.001");
		ip.setDescription("张三用");
		ip.setUsed("1");
		ip.setUser(user);
		session.save(ip);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
